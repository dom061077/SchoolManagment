package com.sms.smr.infra.inputadapter;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.MenuRole;
import com.sms.smr.infra.inputadapter.dto.keycloak.UserInfoDto;
import com.sms.smr.infra.inputadapter.dto.menurole.MenuRoleDto;
import com.sms.smr.infra.inputadapter.utils.Utils;
import com.sms.smr.infra.inputport.BaseInputPort;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryRepository;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryResult;

import lombok.RequiredArgsConstructor;

//@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationApi {
    private final static Logger logger = LoggerFactory.getLogger(Authentication.class);
    private final QueryRepository queryRepository;
    
    @Qualifier(value = "menuRoleUseCase")
    private final BaseInputPort<MenuRole, Long> inputPort;
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


/*
  @GetMapping("/menubyrole")
  public QueryResult<MenuRole> getMenubyRole(Authentication authentication){
    //desde un usecase traer todos los roles
    //y luego filtrarlos de los que estén asignados al usuario usando stream filters
    logger.info("MenubyRole: ");
    Collection<String> roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
      .collect(Collectors.toList());
    roles.stream().collect(Collectors.joining(","));
    String filterStr = "";
    String orderStr = "";
    var qFilters = Utils.stringToQueryFilterDto(filterStr);
    var qOrders = Utils.stringToQueryFilterDto(orderStr);
    
    return inputPort.getAll(0, 100, qFilters, qOrders );
  }
  */


  private List<MenuRoleDto> getMenubyRole(Authentication authentication){
    //desde un usecase traer todos los roles
    //y luego filtrarlos de los que estén asignados al usuario usando stream filters
    logger.info("MenubyRole: ");
    Collection<String> roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
      .collect(Collectors.toList());
    
    String filterStr = "[{\"property\": \"role:eqin\",\"value\":\""
      + roles.stream().collect(Collectors.joining(","))
      +"\"}]";
    filterStr = filterStr.replaceAll("ROLE_", "");
    String orderStr = "";
    var qFilters = Utils.stringToQueryFilterDto(filterStr);
    var qOrders = Utils.stringToQueryFilterDto(orderStr);
    QueryResult qResult = inputPort.getAll(0, 100, qFilters, qOrders );
    return qResult.getData();
  }  
  

  @GetMapping("/userinfo")
  public UserInfoDto getUserInfo(Authentication authentication){
    UserInfoDto userInfo = new UserInfoDto();    
    Jwt jwt = null;
    if (authentication instanceof JwtAuthenticationToken jwtAuthToken) {
      jwt = jwtAuthToken.getToken();

    }
    
    //jwt.getClaim("name")
    //email
    //preferred_username
    //family_name
    //given_name
    //sid

  
    userInfo.setName(jwt.getClaim("name"));
    userInfo.setEmail(jwt.getClaim("email"));
    userInfo.setPreferred_username(jwt.getClaim("preferred_username"));
    userInfo.setFamily_name(jwt.getClaim("family_name"));
    userInfo.setGiven_name(jwt.getClaim("given_name"));
    userInfo.setSid(jwt.getClaim("sid"));
    userInfo.setMenus(this.getMenubyRole(authentication));

    return userInfo;
  }

}
