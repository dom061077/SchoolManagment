package com.sms.smr.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuRole extends BaseDomain {


    
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
