package com.sms.smr.infra.outputadapter.jparepository.queryrepository;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryResult<T> {
    private int total;
    private List<T> data;
    
}
