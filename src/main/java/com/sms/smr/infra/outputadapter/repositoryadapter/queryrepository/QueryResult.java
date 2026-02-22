package com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryResult<T> {
    private long total;
    private List<T> data;
    
}
