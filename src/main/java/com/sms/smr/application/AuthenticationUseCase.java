package com.sms.smr.application;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.smr.domain.AuthenticationRequest;
import com.sms.smr.domain.AuthenticationResponse;
import com.sms.smr.domain.Menu;
import com.sms.smr.domain.RegisterRequest;
import com.sms.smr.domain.Token;
import com.sms.smr.domain.TokenType;
import com.sms.smr.infra.inputadapter.dto.query.QueryFilterDto;
import com.sms.smr.infra.outputadapter.db.MenuEntity;
import com.sms.smr.infra.outputadapter.db.MenuRoleEntity;
import com.sms.smr.infra.outputadapter.db.TokenEntity;
import com.sms.smr.infra.outputadapter.db.UserEntity;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepository;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;
import com.sms.smr.infra.outputadapter.jparepository.user.TokenRepository;
import com.sms.smr.infra.outputadapter.jparepository.user.UserRepository;
import com.sms.smr.infra.outputadapter.mapper.MenuEntityMapper;
//import com.sms.smr.infra.outputadapter.mapper.TokenEntityMapper;
//import com.sms.smr.infra.outputadapter.mapper.UserEntityMapper;
import com.sms.smr.infra.outputport.EntityRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sms.smr.domain.Role;;

@RequiredArgsConstructor
@Component
public class AuthenticationUseCase {

    private final TokenRepository tokenRepository;
    private final UserRepository userRepository;
    private final EntityRepository menuRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;   
    private final QueryRepository queryRepository;
    private final MenuEntityMapper menuEntityMapper;

    //private final TokenEntityMapper tokenEntMapper;
    //private final UserEntityMapper userEntMapper;
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationUseCase.class);
    
  public AuthenticationResponse register(RegisterRequest request) {
    var user = UserEntity.builder()
        .firstname(request.getFirstname())
        .lastname(request.getLastname())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(request.getRole())
        .build();
    var savedUser = userRepository.save( user);
    var jwtToken = jwtService.generateToken(user);
    var refreshToken = jwtService.generateRefreshToken(user);
    
    var qfDto = QueryFilterDto.builder()
                  .property("code:eq")
                  .value(savedUser.getRole().name())
                  .build();
    var qfDtoList = List.of(qfDto);
    var menuRoleEntityList = queryRepository.getAllAnd(MenuRoleEntity.class, 0, 1, qfDtoList, null).getData();
    
    List<Menu> menus = (List<Menu>)menuRoleEntityList.stream()
    //.filter(item -> item instanceof MenuRoleEntity) // Filter out elements that are not MenuRoleEntity
    .map(item -> {
        //MenuRoleEntity menuRoleEntity = (MenuRoleEntity) item;
        return menuEntityMapper.toDomain(((MenuRoleEntity)item).getMenu());
    })
    .collect(Collectors.toList());

    saveUserToken((UserEntity)savedUser, jwtToken); 
    return AuthenticationResponse.builder()
        .accessToken(jwtToken)
        .refreshToken(refreshToken)
        .firstname(savedUser.getFirstname())
        .lastname(savedUser.getLastname())
        .email(savedUser.getEmail())
        .role(savedUser.getRole())
        .menuList(menus)
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
    var role = ((UserEntity)user).getRole();
    revokeAllUserTokens((UserEntity)user);
    saveUserToken((UserEntity)user, jwtToken);
    var collectionAuth = ((UserEntity)user).getAuthorities();
    var qfDto = QueryFilterDto.builder()
                  .property("role:eq")
                  .value(((UserEntity)user).getRole().name())
                  .build();
    var qfDtoList = List.of(qfDto);    
    QueryResult qResult =  queryRepository.getAllAnd(MenuRoleEntity.class, 0, 100, qfDtoList, null);
   
    List<Menu> menus = (List<Menu>)qResult.getData().stream()
    //.filter(item -> item instanceof MenuRoleEntity) // Filter out elements that are not MenuRoleEntity
    .map(item -> {
        //MenuRoleEntity menuRoleEntity = (MenuRoleEntity) item;
        return menuEntityMapper.toDomain(((MenuRoleEntity)item).getMenu());
    })
    .collect(Collectors.toList());
    
    
    return AuthenticationResponse.builder()
        .id(((UserEntity)user).getId())
        .firstname(((UserEntity)user).getFirstname())
        .lastname(((UserEntity)user).getLastname())
        .accessToken(jwtToken)
        .refreshToken(refreshToken)
        .role(role)
        .menuList(menus)
        .build();
  }

  private void saveUserToken(UserEntity user, String jwtToken) {
    var token = TokenEntity.builder()
        .user(user)
        .token(jwtToken)
        .tokenType(TokenType.BEARER)
        .expired(false)
        .revoked(false)
        .build();
    tokenRepository.save( token);
  }

  private void revokeAllUserTokens(UserEntity user) {
    var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
    if (validUserTokens.isEmpty())
      return;
    validUserTokens.forEach(token -> {
      ((TokenEntity)token).setExpired(true);
      ((TokenEntity)token).setRevoked(true);
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
        revokeAllUserTokens((UserEntity)user);
        saveUserToken((UserEntity)user, accessToken);
        var authResponse = AuthenticationResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
        new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
      }
    }
  }  
  
  public List<Role> findByRole(String code){

    return null;
  }

}
