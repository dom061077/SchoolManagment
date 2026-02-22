package com.sms.smr.infra.outputadapter.jpa;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.sms.smr.infra.exception.InternalServerErrorException;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.inputadapter.utils.Utils;
import com.sms.smr.infra.outputadapter.mapper.CycleAvoidingMappingContext;
import com.sms.smr.infra.outputadapter.mapper.EntityMapper;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryRepository;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryResult;
import com.sms.smr.infra.outputport.CrudOutputPort;



public abstract class BaseRepository<T, ID, E, R extends JpaRepository<E, ID>> implements CrudOutputPort<T, ID>{
    
    protected final R repository;
    protected final EntityMapper<T, E> mapper;

    protected Class<E> clazz;
    private static final Logger logger = LoggerFactory.getLogger(BaseRepository.class);

    public BaseRepository(R repository, EntityMapper<T,E> mapper, Class<E> clazz) {
        this.repository = repository;
        this.mapper = mapper;
        this.clazz = clazz;
    }





    @Override
    public Optional<T> delete(ID id) {
        Optional<E> regEntOpt = repository.findById(id);
        if(regEntOpt.isPresent()) {
            try {
                regEntOpt.get().getClass().getMethod("setDeleted", boolean.class).invoke(regEntOpt.get(), true);
                //repository.save(regEntOpt.get());
            } catch (IllegalAccessException e) {
                logger.error("Error en IllegalAccessException", e);
                throw new InternalServerErrorException("IllegalAccessException. Error al eliminar el registro con Id: "+id);
            } catch (InvocationTargetException e) {
                logger.error("IllegalAccessException. Error en InvocationTargetException");
                throw new InternalServerErrorException("InvocationTargetException. Error al eliminar el registro con Id: "+id);

            } catch (NoSuchMethodException e) {
                logger.error("NoSuchMethodException. Error en NoSuchMethodException", e);
                throw new InternalServerErrorException("NoSuchMethodException. Error al eliminar el registro con Id: "+id);
            } catch (SecurityException e) {
                logger.error("SecurityException. Error en SecurityException", e);
                throw new InternalServerErrorException("SecurityException. Error al eliminar el registro con Id: "+id);
            }
            return Optional.of(mapper.toDomain(regEntOpt.get(), new CycleAvoidingMappingContext()));
        }
        else
            throw new InternalServerErrorException("El registro no existe. Registro con Id: "+id+" no existe");
        
    }

    /*@Override
    public Page<T> getAll(int offset, int limit, String queryFilters, String sortFilters, String globalOperator) {
        List<QueryDto> queryFilterDtos = Utils.stringToQueryFilterDto(queryFilters);
        List<QueryDto> sortFilterDtos = Utils.stringToQueryFilterDto(sortFilters);
        Page<E> page = queryRepository.getAll(offset, limit, queryFilterDtos, sortFilterDtos, globalOperator);
        return page.map(
            (entity) ->{ 
                return mapper.toDomain(entity, new CycleAvoidingMappingContext());
            });
    }*/


    /*@Override
    public QueryResult<T> getAll( int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortFilters) {
        QueryResult<T>  qResult = new QueryResult<T>();
         qResult.setTotal(queryRepository.getCount(clazz,queryFilters));
         qResult.setData(mapper.getDomainList(queryRepository.getAllAnd( (Class<E>) clazz,offset, limit, queryFilters, sortFilters),new CycleAvoidingMappingContext()));

        return qResult;
        
    }*/

    @Override
    public Optional<T> getById(ID id) {

        Optional<E> regEntOpt = repository.findById(id);
        if(regEntOpt.isPresent())
            return  Optional.of(mapper.toDomain(regEntOpt.get(), new CycleAvoidingMappingContext()));
        else
            throw new InternalServerErrorException("Registro con Id: "+id+" no existe");
    }


    @Override
    public T save(T reg) {
        
        E createdEntity = repository.save(mapper.toEntity(reg, new CycleAvoidingMappingContext()));
        return mapper.toDomain(createdEntity, new CycleAvoidingMappingContext());
        
    }

    @Override
    public Optional<T> update(ID id, T reg) {
        return repository.findById(id).map(entity->{
            mapper.updateEntityFromDomain(reg,entity, new CycleAvoidingMappingContext());
            //E saved = repository.save(entity);
            return mapper.toDomain(entity, new CycleAvoidingMappingContext());
        });
    }


    


}
