package com.sms.smr.infra.outputadapter.jparepository.queryrepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.management.Query;

import org.springframework.stereotype.Component;

import com.sms.smr.infra.outputadapter.db.AlumnoEntity;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Component
public class QueryRepositoryImpl implements QueryRepository {
    @PersistenceContext
    private  EntityManager em;

    private CriteriaBuilder cb;

    public QueryRepositoryImpl(){
        cb = em.getCriteriaBuilder();
    }

    @Override
    public <T> List<T> getAllOr(Class<T> clazz, int offset, int limit, Map<String, Object> params) {
        List <T> result = null;

        return result;
    }
    
    @Override
    public <T> List<T> getAllAnd(Class<T> clazz, int offset, int limit, Map<String, Object> params) {
        
        CriteriaQuery<T> criteriaQuery = cb.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        
        //Parameter<String> userInputParameter = criteriaBuilder.parameter(String.class);

        criteriaQuery.select(root);

        List<Predicate> predicates = getPredicates(params);
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

    private List<Predicate> getPredicates( Map <String, Object> params,Root root) {
        List<Predicate> predicates = new ArrayList();
        
        params.entrySet().forEach(entry->{
            String[] splitted=entry.getKey().split(":");
            if ( splitted.length !=2)
                throw new IllegalArgumentException("Parameter type filter is not correct. Example of correct filter typ --> gt:PropertyName");
            if (QueryFilterEnum.valueOf(splitted[0]) == QueryFilterEnum.EQUAL )
                predicates.add(cb.equal(root.get(splitted[1]), entry.getValue()));
            if (QueryFilterEnum.valueOf(splitted[0])== QueryFilterEnum.GREATER_THAN)
                predicates.add(cb.gt(new Expression(),18));
        });
        /*if(filter == QueryFilterEnum.EQUAL){
            return cb.equal(ex, value);
        }
        if(filter == QueryFilterEnum.GREATER_THAN){
            if (value instanceof Number)
                return cb.gt( ex,(Number)value);

        }
        
        if(filter == QueryFilterEnum.LIKE){
            if (value instanceof String)
                return cb.like(ex, value.toString());
        }*/
        return predicates;
    }
    
}
