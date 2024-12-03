package com.sms.smr.infra.inputadapter;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.infra.inputport.UserInputPort;

import lombok.RequiredArgsConstructor;

//@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserApi {
    private final UserInputPort useInputPort;
    
    @GetMapping(value="menu-roles")
    public Collection<String> getMenuByRole(Authentication authentication){
        Collection<String> roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

        return roles;
    }
}
