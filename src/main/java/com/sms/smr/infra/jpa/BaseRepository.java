package com.sms.smr.infra.jpa;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.smr.infra.exception.InternalServerErrorException;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepository;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;
import com.sms.smr.infra.outputadapter.mapper.EntityMapper;
import com.sms.smr.infra.outputport.CrudOutputPort;

public abstract class BaseRepository<T, ID, E, R extends JpaRepository<E, ID>, Q extends QueryRepository<E>> implements CrudOutputPort<T, ID>{
    
    protected final R repository;
    protected final EntityMapper<T, E> mapper;
    protected final Q queryRepository;
    protected Class<E> clazz;
    private static final Logger logger = LoggerFactory.getLogger(BaseRepository.class);

    public BaseRepository(R repository, EntityMapper<T,E> mapper, Q queryRepository, Class<E> clazz) {
        this.repository = repository;
        this.mapper = mapper;
        this.queryRepository = queryRepository;
        this.clazz = clazz;
    }





    @Override
    public Optional<T> delete(ID id) {
        throw new NotImplementedException();
    }

    @Override
    public QueryResult<T> getAll( int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortFilters) {
        QueryResult<T>  qResult = new QueryResult<T>();
         qResult.setTotal(queryRepository.getCount(clazz,queryFilters));
         qResult.setData(mapper.getDomainList(queryRepository.getAllAnd( (Class<E>) clazz,offset, limit, queryFilters, sortFilters)));

        return qResult;
        
    }

    @Override
    public Optional<T> getById(ID id) {

        Optional<E> regEntOpt = repository.findById(id);
        if(regEntOpt.isPresent())
            return  Optional.of(mapper.toDomain(regEntOpt.get()));
        else
            throw new InternalServerErrorException("Registro con Id: "+id+" no existe");
    }

    @Override
    public long getCount(List<QueryDto> queryFilters) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public T save(T reg) {
        
        E createdEntity = repository.save(mapper.toEntity(reg));
        return mapper.toDomain(createdEntity);
        
    }

    @Override
    public Optional<T> update(ID id, T reg) {
        return repository.findById(id).map(entity->{
            mapper.updateEntityFromDomain(reg,entity);
            E saved = repository.save(entity);
            return mapper.toDomain(saved);
        });
    }


    


}
