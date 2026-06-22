package com.sms.smr.domain.ports.in;

import java.util.Optional;

import com.sms.smr.domain.model.PageResponse;


public interface BaseUseCase<T, ID> {
    T create(T entity);
    Optional<T> getById(ID id);
    T update(ID id, T domain);
    boolean delete(ID id);
    PageResponse<T> getAll(int offset, int limit, String queryFilters, String sortings, String loperator);
}
