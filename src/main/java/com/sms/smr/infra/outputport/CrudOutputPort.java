package com.sms.smr.infra.outputport;

import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface CrudOutputPort<T, ID> {
    public  T save(T reg);

    public  Optional<T> getById( ID id );

    public  QueryResult<T>  getAll(  int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortFilters );    

    public Page<T> getAll(int offset, int limit, String queryFilters, String sortFilters, String globalOperator);

    public long getCount(List<QueryDto> queryFilters);

    public  Optional<T> update(ID id, T reg);

    public  Optional<T> delete(ID id);
}
