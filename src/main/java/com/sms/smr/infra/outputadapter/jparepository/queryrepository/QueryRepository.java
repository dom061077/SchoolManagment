package com.sms.smr.infra.outputadapter.jparepository.queryrepository;

import java.util.List;
import java.util.Map;

public interface QueryRepository {
    // Define custom query methods if needed
    public <T> List<T> getAll(Class<T> clazz,int offset,int limit,Map<T,Object> params);
}