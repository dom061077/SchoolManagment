package com.sms.smr.infra.outputadapter.jparepository.queryrepository;

import java.util.List;

import com.sms.smr.infra.inputadapter.dto.query.QueryDto;

public interface QueryRepository<T, ID> {
    // Define custom query methods if needed
    public List<T> getAllAnd(int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortingFilters);
    public  List<T> getAllAnd(Class<T> clazz,int offset,int limit,List<QueryDto> queryFilters,List<QueryDto> sortingFilters);
    public  List<T> getAllOr(Class<T> clazz,int offset,int limit,List<QueryDto> queryFilters);
    public  long getCount(Class<T> clazz, List<QueryDto> queryFilters);
}