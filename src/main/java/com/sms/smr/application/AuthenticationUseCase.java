package com.sms.smr.application;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.smr.domain.AuthenticationRequest;
import com.sms.smr.domain.AuthenticationResponse;
import com.sms.smr.domain.RegisterRequest;
import com.sms.smr.domain.Token;
import com.sms.smr.domain.TokenType;
import com.sms.smr.domain.User;
import com.sms.smr.infra.outputadapter.jparepository.user.TokenRepository;
import com.sms.smr.infra.outputadapter.jparepository.user.UserRepository;
import com.sms.smr.infra.outputadapter.mapper.TokenEntityMapper;
import com.sms.smr.infra.outputadapter.mapper.UserEntityMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AuthenticationUseCase {

    private final TokenRepository tokenRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;   
    private final TokenEntityMapper tokenEntMapper;
    private final UserEntityMapper userEntMapper;
    
  public AuthenticationResponse register(RegisterRequest request) {
    var user = User.builder()
        .firstname(request.getFirstname())
        .lastname(request.getLastname())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(request.getRole())
        .build();
    var savedUser = userRepository.save( userEntMapper.toDbo(user));
    var jwtToken = jwtService.generateToken(user);
    var refreshToken = jwtService.generateRefreshToken(user);
    saveUserToken(userEntMapper.toDomain( savedUser), jwtToken);
    return AuthenticationResponse.builder()
        .accessToken(jwtToken)
            .refreshToken(refreshToken)
        .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    var user = userRepository.findByEmail(request.getEmail())
        .orElseThrow();
    var jwtToken = jwtService.generateToken((UserDetails)user);
    var refreshToken = jwtService.generateRefreshToken((UserDetails)user);
    revokeAllUserTokens((User)user);
    saveUserToken((User)user, jwtToken);
    return AuthenticationResponse.builder()
        .accessToken(jwtToken)
            .refreshToken(refreshToken)
        .build();
  }

  private void saveUserToken(User user, String jwtToken) {
    var token = Token.builder()
        .user(user)
        .token(jwtToken)
        .tokenType(TokenType.BEARER)
        .expired(false)
        .revoked(false)
        .build();
    tokenRepository.save( tokenEntMapper.toDbo( token));
  }

  private void revokeAllUserTokens(User user) {
    var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
    if (validUserTokens.isEmpty())
      return;
    validUserTokens.forEach(token -> {
      ((Token)token).setExpired(true);
      ((Token)token).setRevoked(true);
    });
    //List<Token> tokens = (List<Token>)validUserTokens;
    
    tokenRepository.saveAll(validUserTokens);
  }



  public void refreshToken(
          HttpServletRequest request,
          HttpServletResponse response
  ) throws IOException {
    final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
    final String refreshToken;
    final String userEmail;
    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
      return;
    }
    refreshToken = authHeader.substring(7);
    userEmail = jwtService.extractUsername(refreshToken);
    if (userEmail != null) {
      var user = this.userRepository.findByEmail(userEmail)
              .orElseThrow();
      if (jwtService.isTokenValid(refreshToken, (UserDetails)user)) {
        var accessToken = jwtService.generateToken((UserDetails)user);
        revokeAllUserTokens((User)user);
        saveUserToken((User)user, accessToken);
        var authResponse = AuthenticationResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
        new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
      }
    }
  }    
}
