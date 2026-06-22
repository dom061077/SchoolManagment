package com.sms.smr.infra.input;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryResult<T> {
    private long totalElements;
    private List<T> content;
    
}
