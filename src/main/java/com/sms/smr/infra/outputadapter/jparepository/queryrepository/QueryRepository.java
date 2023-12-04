package com.sms.smr.infra.outputadapter.jparepository.queryrepository;

import java.util.List;
import java.util.Map;

import com.sms.smr.infra.inputadapter.dto.query.QueryFilterDto;

public interface QueryRepository {
    // Define custom query methods if needed
    public <T> List<T> getAllAnd(Class<T> clazz,int offset,int limit,List<QueryFilterDto> queryFilters);
    public <T> List<T> getAllOr(Class<T> clazz,int offset,int limit,List<QueryFilterDto> queryFilters);
}