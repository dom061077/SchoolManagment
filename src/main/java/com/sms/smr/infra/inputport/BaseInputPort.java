package com.sms.smr.infra.inputport;

import java.util.List;
import java.util.Optional;

import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;

public interface BaseInputPort<T> {
    T create(T entity);
    Optional<T> getById(Long id);
    QueryResult<T> getAll(int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortings);
    Optional<T> update(Long id, T entity);
    boolean delete(Long id);
}
