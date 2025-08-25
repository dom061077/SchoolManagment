package com.sms.smr.infra.outputadapter.jparepository.queryrepository;

import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import java.util.List;

public interface QueryRepository<T> {
    // Define custom query methods if needed
    public  List<T> getAllAnd(Class<T> clazz,int offset,int limit,List<QueryDto> queryFilters,List<QueryDto> sortingFilters);
    public  List<T> getAllOr(Class<T> clazz,int offset,int limit,List<QueryDto> queryFilters);
    public  long getCount(Class<T> clazz, List<QueryDto> queryFilters);
}