package com.sms.smr.domain.ports.in;

import com.sms.smr.domain.model.PageResponse;

public interface BaseQueryUseCase<T, ID> {
    PageResponse<T> getAll(int offset, int limit, String queryFilters, String sortings, String loperator);

}
