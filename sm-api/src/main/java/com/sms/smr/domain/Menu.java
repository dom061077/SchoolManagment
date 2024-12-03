package com.sms.smr.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Menu {

    private Long id;
    private String description;
    private String code;
  
    
}
