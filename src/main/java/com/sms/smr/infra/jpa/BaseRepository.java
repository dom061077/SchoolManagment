package com.sms.smr.infra.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;
import com.sms.smr.infra.outputadapter.mapper.EntityMapper;
import com.sms.smr.infra.outputport.CrudOutputPort;

public abstract class BaseRepository<T, ID, E, R extends JpaRepository<E, ID>> implements CrudOutputPort<T, ID>{
    
    protected final R repository;
    protected final EntityMapper<T, E> mapper;

    public BaseRepository(R repository, EntityMapper<T,E> mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<T> delete(ID id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public QueryResult<T> getAll(int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortFilters) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<T> getById(ID id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public long getCount(List<QueryDto> queryFilters) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public T create(T reg) {
        
        E createdEntity = repository.save(mapper.toEntity(reg));
        return mapper.toDomain(createdEntity);
        
    }

    @Override
    public Optional<T> update(ID id, T reg) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    


}
