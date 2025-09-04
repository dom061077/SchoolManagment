package com.sms.smr.infra.inputport;

import java.util.List;
import java.util.Optional;

import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;
//to be deprecated
public interface CrudInputPort<T, ID> {
    T create(T entity);
    Optional<T> getById(ID id);
    QueryResult<T> getAll(int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortings);
    Optional<T> update(ID id, T domain);
    boolean delete(ID id);
}
