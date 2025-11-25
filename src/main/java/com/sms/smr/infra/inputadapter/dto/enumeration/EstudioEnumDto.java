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
    private final String id;
    private final String description;
}
