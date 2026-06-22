package com.sms.smr.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Menu extends BaseDomain {


    private String description;
    private String code;
    private String path;
  
    
}
