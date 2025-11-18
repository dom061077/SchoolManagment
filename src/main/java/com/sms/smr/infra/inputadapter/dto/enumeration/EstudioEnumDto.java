package com.sms.smr.infra.inputadapter.dto.enumeration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class EstudioEnumDto {
    private final String code;
    private final String description;
}
