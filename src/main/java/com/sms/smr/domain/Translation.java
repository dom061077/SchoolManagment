package com.sms.smr.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public class Translation extends BaseDomain {


    private String key;
    private String value;
    private String language;
    private String namespace;
    
}
