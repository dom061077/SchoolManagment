package com.sms.smr.domain.ports.out;

import com.sms.smr.domain.model.PageResponse;

public interface QueryPersistenceOutputPort<T, ID> {
    public final static String AND_OPERATOR = "AND";
    public final static String OR_OPERATOR = "OR";
    // Define custom query methods if needed

    public PageResponse<T> getAll(int offset, int limit, String queryFilters, String sortingFilters, String globalOperator);
}