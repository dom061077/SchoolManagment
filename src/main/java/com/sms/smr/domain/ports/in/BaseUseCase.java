package com.sms.smr.domain.ports.in;

import java.util.Optional;

import org.springframework.data.domain.Page;


public interface BaseUseCase<T, ID> {
    T create(T entity);
    Optional<T> getById(ID id);
    T update(ID id, T domain);
    boolean delete(ID id);
    Page<T> getAll(int offset, int limit, String queryFilters, String sortings, String loperator);
}
