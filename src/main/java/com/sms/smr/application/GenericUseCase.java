package com.sms.smr.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.inputport.CrudInputPort;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;
import com.sms.smr.infra.outputport.CrudOutputPort;


import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class GenericUseCase<T, ID extends Long> implements CrudInputPort<T, ID> {

    private final CrudOutputPort<T,ID> repository;

    @Override 
    public T create(T entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<T> getById(ID id) {
        return repository.getById(id);
    }

    @Override
    public QueryResult<T> getAll(int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortings) {
        return repository.getAll(offset, limit, queryFilters, queryFilters);
    }

    @Override
    public Optional<T> update(ID id, T domain) {
        return repository.update(id, domain);
    }

    @Override
    public boolean delete(ID id) {
        Optional<T> deletedDomain = repository.delete(id);
        if(deletedDomain.isPresent())
            return true;
        else 
            return false;    
        
    }


}
