package com.sms.smr.infra.outputport;

import java.util.List;

import com.sms.smr.infra.inputadapter.dto.query.QueryFilterDto;

public interface EntityRepository {
    
    public <T> T save(T reg);

    public <T> T getById( Long id );

    public <T> List<T> getAll( int offset, int limit, List<QueryFilterDto> queryFilters, List<QueryFilterDto> sortFilters );    
}
