package com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository;

import java.util.List;

import org.springframework.data.domain.Page;

import com.sms.smr.infra.inputadapter.dto.query.QueryDto;

public interface QueryRepository<T, ID> {
    public final static String AND_OPERATOR = "AND";
    public final static String OR_OPERATOR = "OR";
    // Define custom query methods if needed
    public List<T> getAllAnd(int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortingFilters);
    public  List<T> getAllAnd(Class<T> clazz,int offset,int limit,List<QueryDto> queryFilters,List<QueryDto> sortingFilters);
    public  List<T> getAllOr(Class<T> clazz,int offset,int limit,List<QueryDto> queryFilters);
    public  long getCount(Class<T> clazz, List<QueryDto> queryFilters);

    public Page<T> getAll(int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortingFilters, String globalOperator);
}