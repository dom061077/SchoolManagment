package com.sms.smr.infra.outputadapter.jparepository.queryrepository;

import java.util.List;

import com.sms.smr.infra.inputadapter.dto.query.QueryDto;

public interface QueryRepository {
    // Define custom query methods if needed
    public <T> List<T> getAllAnd(Class<T> clazz,int offset,int limit,List<QueryDto> queryFilters,List<QueryDto> sortingFilters);
    public <T> List<T> getAllOr(Class<T> clazz,int offset,int limit,List<QueryDto> queryFilters);
    public <T> long getCount(Class<T> clazz, List<QueryDto> queryFilters);
}