package com.sms.smr.infra.outputadapter.jparepository.queryrepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sms.smr.domain.alumno.Alumno;
import com.sms.smr.domain.person.Person;
import com.sms.smr.infra.inputadapter.dto.query.QueryFilterDto;
import com.sms.smr.infra.outputadapter.db.AlumnoEntity;
import com.sms.smr.infra.outputadapter.db.PersonEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Component
public class QueryRepositoryImpl implements QueryRepository {
    @PersistenceContext
    private  EntityManager em;

    private static final Logger logger = LoggerFactory.getLogger(QueryRepositoryImpl.class); 


    private Class getEntityClass(Class clazz){
        if (clazz.equals(Person.class))
            return PersonEntity.class;
        if (clazz.equals(Alumno.class))
            return AlumnoEntity.class;
        return null;
    }

    @Override
    public <T> List<T> getAllOr(Class<T> clazz, int offset, int limit, List<QueryFilterDto> queryFilters) {
        List <T> result = null;

        return result;
    }
    
    @Override
    public <T> List<T> getAllAnd(Class<T> clazz, int offset, int limit, List<QueryFilterDto> queryFilters) {

        clazz = getEntityClass(clazz);

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = cb.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        
        //Parameter<String> userInputParameter = criteriaBuilder.parameter(String.class);
        //cb = em.getCriteriaBuilder();
        criteriaQuery.select(root);

        List<Predicate> predicates = getPredicates(queryFilters,root);
        Predicate predicate = cb.and(predicates.toArray(new Predicate[0]));

        criteriaQuery.where(predicate);
        
        List<T> result =
            em
                .createQuery(criteriaQuery)
                .setMaxResults(limit)
                .setFirstResult(offset)
                .getResultList();
        

        return (List<T>) result;      
    }

    private List<Predicate> getPredicates( List<QueryFilterDto> queryFilters,Root root) {
        logger.info("Ingresando a getPredicates");
        List<Predicate> predicates = new ArrayList();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        queryFilters.forEach(q->{
            
            String[] splitted = q.getProperty().split(":");
            logger.info("splitted[0]: "+splitted[0]);
            logger.info("splitted[1]: "+splitted[1]);
            if(splitted.length != 2){
                throw new IllegalArgumentException("Parameter type filter is not correct. Example of correct filter --> gt:PropertyName");
            }
            if(QueryFilterEnum.valueOf(splitted[1]) == QueryFilterEnum.eq){
                predicates.add(cb.equal(root.get(splitted[0]), q.getValue()));
            }
            if(QueryFilterEnum.valueOf(splitted[1]) == QueryFilterEnum.like){
                predicates.add(cb.like(cb.upper( root.get(splitted[0])), "%"+q.getValue().toUpperCase()+"%"));
            }
        });

        /*params.entrySet().forEach(entry->{
            String[] splitted=entry.getKey().split(":");
            if ( splitted.length !=2)
                throw new IllegalArgumentException("Parameter type filter is not correct. Example of correct filter typ --> gt:PropertyName");
            if (QueryFilterEnum.valueOf(splitted[0]) == QueryFilterEnum.EQUAL )
                predicates.add(cb.equal(root.get(splitted[1]), entry.getValue()));
            if (QueryFilterEnum.valueOf(splitted[0])== QueryFilterEnum.GREATER_THAN)
                predicates.add(cb.gt(root.get(""),(Integer)entry.getValue()));
        });*/

        return predicates;
    }
    
}
