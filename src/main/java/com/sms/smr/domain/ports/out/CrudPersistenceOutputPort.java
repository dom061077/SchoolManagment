package com.sms.smr.domain.ports.out;

import java.util.Optional;

public interface CrudPersistenceOutputPort<T, ID> {
    public  T save(T reg);

    public  Optional<T> getById( ID id );

    //public  QueryResult<T>  getAll(  int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortFilters );    

    //public Page<T> getAll(int offset, int limit, String queryFilters, String sortFilters, String globalOperator);

    //public long getCount(List<QueryDto> queryFilters);

    public  Optional<T> update(ID id, T reg);

    public  Optional<T> delete(ID id);
}
