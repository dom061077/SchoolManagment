package com.sms.smr.domain.ports.out;

import org.springframework.data.domain.Page;

public interface QueryPersistenceOutputPort<T, ID> {
    public final static String AND_OPERATOR = "AND";
    public final static String OR_OPERATOR = "OR";
    // Define custom query methods if needed

    public Page<T> getAll(int offset, int limit, String queryFilters, String sortingFilters, String globalOperator);
}