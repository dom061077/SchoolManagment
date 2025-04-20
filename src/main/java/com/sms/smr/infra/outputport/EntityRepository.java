package com.sms.smr.infra.outputport;

import java.util.List;
import java.util.Optional;

import com.sms.smr.infra.inputadapter.dto.query.QueryDto;

public interface EntityRepository<T>{
    
    public  T save(T reg);

    public  Optional<T> getById( Long id );

    public  List<T> getAll( int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortFilters );    

    public long getCount(List<QueryDto> queryFilters);

    public   Optional<T> update(Long id,T reg);

    public  Optional<T> delete(Long id);
}
