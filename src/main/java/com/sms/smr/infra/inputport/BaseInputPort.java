package com.sms.smr.infra.inputport;

import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryResult;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

//to be deprecated
//It's use in older use case
public interface BaseInputPort<T, ID> {
    T create(T entity);
    Optional<T> getById(ID id);
    QueryResult<T> getAll(int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortings);
    T update(ID id, T domain);
    boolean delete(ID id);
    Page<T> getAll(int offset, int limit, String queryFilters, String sortings, String loperator);
}
