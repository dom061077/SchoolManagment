package com.sms.smr.infra.jpa;

import java.util.List;
import java.util.Optional;

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


    public BaseRepository(R repository, EntityMapper<T,E> mapper, Q queryRepository, Class<E> clazz) {
        this.repository = repository;
        this.mapper = mapper;
        this.queryRepository = queryRepository;
        this.clazz = clazz;
    }





    @Override
    public Optional<T> delete(ID id) {
        Optional<E> regEntOpt = repository.findById(id);
        if(regEntOpt.isPresent()){
            repository.deleteById(id);
            return Optional.of(mapper.toDomain(regEntOpt.get()));
        }   
        return Optional.empty();
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
    public T create(T reg) {
        
        E createdEntity = repository.save(mapper.toEntity(reg));
        return mapper.toDomain(createdEntity);
        
    }

    @Override
    public Optional<T> update(ID id, T reg) {
        Optional<E> regEntOpt = repository.findById(id);
        if(regEntOpt.isPresent()){          
            E entityToUpdate = mapper.toEntity(reg);
            //se asegura que el id del entity a actualizar sea el mismo del id del path
            //en caso de que vengan diferente en el dto
            //((BaseEntity)entityToUpdate).setId((Long)id); 
            E updatedEntity = repository.save(entityToUpdate);
            return Optional.of(mapper.toDomain(updatedEntity));
        }
        return Optional.empty();
    }

    


}
