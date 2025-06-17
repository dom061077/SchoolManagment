package com.sms.smr.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Translation {
    private Long id;

    private String key;
    private String value;
    private String language;

}
