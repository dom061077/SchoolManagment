package com.sms.smr.infra.inputadapter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.application.AuthenticationUseCase;
import com.sms.smr.domain.AuthenticationRequest;
import com.sms.smr.domain.AuthenticationResponse;
import com.sms.smr.domain.RegisterRequest;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import static java.util.stream.Collectors.toSet;

//@RestController
//@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationApi {

/*   private final AuthenticationUseCase service;

  @PostMapping(value="/register",produces=MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
  }
  //@PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }

  @PostMapping("/refresh-token")
  public void refreshToken(
      HttpServletRequest request,
      HttpServletResponse response
  ) throws  java.io.IOException {
    service.refreshToken(request, response);
  } */

  
  @GetMapping("/roles")
  public Collection<String> getRoles(Authentication authentication) {
      return authentication.getAuthorities().stream()
              .map(GrantedAuthority::getAuthority)
              .collect(Collectors.toList());
  }

  @GetMapping("/menubyrole")
  public Collection<String> getMenubyRole(){

    return null;
  }

}
