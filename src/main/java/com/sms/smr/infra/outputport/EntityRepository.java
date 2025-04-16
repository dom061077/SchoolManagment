package com.sms.smr.infra.outputport;

import java.util.List;
import java.util.Optional;

import com.sms.smr.infra.inputadapter.dto.query.QueryDto;

public interface EntityRepository{
    
    public <T> T save(T reg);

    public <T> Optional<T> getById( Long id );

    public <T> List<T> getAll( int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortFilters );    

    public long getCount(List<QueryDto> queryFilters);

    public <T>  Optional<T> update(Long id,T reg);
}
