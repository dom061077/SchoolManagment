package com.sms.smr.infra.outputadapter.jparepository.queryrepository;

import java.util.List;


import com.sms.smr.infra.inputadapter.dto.query.QueryFilterDto;

public interface QueryRepository {
    // Define custom query methods if needed
    public <T> List<T> getAllAnd(Class<T> clazz,int offset,int limit,List<QueryFilterDto> queryFilters,List<QueryFilterDto> sortingFilters);
    public <T> List<T> getAllOr(Class<T> clazz,int offset,int limit,List<QueryFilterDto> queryFilters);
    public <T> long getCount(Class<T> clazz, List<QueryFilterDto> queryFilters);
}