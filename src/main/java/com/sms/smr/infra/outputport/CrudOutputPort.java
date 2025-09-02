package com.sms.smr.infra.outputport;

import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;
import java.util.List;
import java.util.Optional;

public interface CrudOutputPort<T, ID> {
    public  T save(T reg);

    public  Optional<T> getById( ID id );

    public  QueryResult<T>  getAll( int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortFilters );    

    public long getCount(List<QueryDto> queryFilters);

    public   Optional<T> update(ID id,T reg);

    public  Optional<T> delete(ID id);
}
