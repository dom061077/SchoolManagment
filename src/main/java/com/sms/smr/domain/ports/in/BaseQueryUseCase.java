package com.sms.smr.domain.ports.in;

import org.springframework.data.domain.Page;

public interface BaseQueryUseCase<T, ID> {
    Page<T> getAll(int offset, int limit, String queryFilters, String sortings, String loperator);

}
