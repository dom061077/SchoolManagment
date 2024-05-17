package com.sms.smr.infra.inputadapter.dto.query;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class QueryFilterDto {
    String property;
    String value;

}
