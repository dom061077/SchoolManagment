package com.sms.smr.infra.outputadapter.jparepository.queryrepository;

import java.util.List;
import java.util.Map;

public interface QueryRepository {
    // Define custom query methods if needed
    public <T> List<T> getAll(int offset,int limit,Map<String,Object> params);
}