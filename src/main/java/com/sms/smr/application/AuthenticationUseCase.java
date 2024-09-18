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

    //private final TokenRepository tokenRepository;
    //private final UserRepository userRepository;
    private final EntityRepository menuRepository;
    //private final PasswordEncoder passwordEncoder;
    //private final JwtService jwtService;
    //private final AuthenticationManager authenticationManager;   
    private final QueryRepository queryRepository;
    private final MenuEntityMapper menuEntityMapper;

    //private final TokenEntityMapper tokenEntMapper;
    //private final UserEntityMapper userEntMapper;
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationUseCase.class);
    
  /*public List<Role> findByRole(String code){

    return null;
  }*/

  public List<String> fundByMenuRole(){
    
    return null;
  }

}
