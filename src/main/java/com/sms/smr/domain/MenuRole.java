package com.sms.smr.domain;

import com.sms.smr.infra.outputadapter.db.MenuEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class MenuRole {

    private Long id;   
    
    MenuEntity menu;

    Role role;    
}
