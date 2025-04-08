package com.sms.smr.infra.inputadapter.dto.keycloak;

import java.util.List;

import com.sms.smr.infra.inputadapter.dto.menurole.MenuRoleDto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserInfoDto {
    //jwt.getClaim("name")
    //email
    //preferred_username
    //family_name
    //given_name
    //sid    

    private String name;

    private String email;

    private String preferred_username;

    private String family_name;

    private String given_name;

    private String sid;

    private List<MenuRoleDto> menus;

    
}
