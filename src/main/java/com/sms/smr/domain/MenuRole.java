package com.sms.smr.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class MenuRole {

    private Long id;   
    
    //MenuDomain
    //private Long id;
    //private String description;
    //private String code;
    //private String path;

    Menu menu;

    boolean create;
    boolean update;
    boolean delete;

    String role;   
}
