package com.sms.smr.infra.outputadapter.jparepository.queryrepository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sms.smr.infra.outputadapter.db.AlumnoEntity;

import jakarta.el.Expression;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
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
    public <T> List<T> getAll(Class<T> clazz, int offset, int limit, Map<T, Object> params) {
        CriteriaQuery<T> criteriaQuery = cb.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        criteriaQuery.select(root);

        root.get("");

        params.entrySet().stream().forEach(entry->{
            
        });     
        
        List<T> result =
            em
                .createQuery(criteriaQuery)
                .setMaxResults(limit)
                .setFirstResult(offset)
                .getResultList();
    
        return (List<T>) result;      
    }

    private Predicate getPredicate(Root<Object> root,QueryFilterEnum filter,Object value){
        
        if(filter == QueryFilterEnum.EQUAL){
            return cb.equal(null, value);
        }
        if(filter == QueryFilterEnum.GREATER_THAN){
            return cb.greaterThan( root.get(filter.getFieldValue()), value.toString());
        }
        if(filter == QueryFilterEnum.LIKE){
            return cb.like(root.get(filter.getFieldValue()), value);
        }
        return null;
    }
    
}
