package com.sms.smr.infra.outputadapter.jparepository.queryrepository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
        if (clazz.equals(PersonEntity.class)==true)
            return PersonEntity.class;
        if (clazz.equals(AlumnoEntity.class)==true)
            return AlumnoEntity.class;
        return null;
    }

    @Override
    public <T> List<T> getAllOr(Class<T> clazz, int offset, int limit, List<QueryFilterDto> queryFilters) {
        List <T> result = null;

        return result;
    }
    
    @Override
    public <T> List<T> getAllAnd(Class<T> clazz, int offset, int limit, List<QueryFilterDto> queryFilters, List<QueryFilterDto> sortingFilters) {

        clazz = getEntityClass(clazz);

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = cb.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        addSortings(criteriaQuery, cb, root, sortingFilters);
        
        criteriaQuery.select(root);

        List<Predicate> predicates = getPredicates(queryFilters,root);
        Predicate predicate = cb.and(predicates.toArray(new Predicate[0]));

        criteriaQuery.where(predicate);
        
        List<T> result =
            em
                .createQuery(criteriaQuery)
                .setMaxResults(limit)
                .setFirstResult(offset)
                .getResultList()
                
                ;
        

        return (List<T>) result;      
    }

    private void addSortings(CriteriaQuery cq,CriteriaBuilder cb, Root root, List<QueryFilterDto> sortingFilters){
        sortingFilters.forEach(s->{

            if(s.getValue().toUpperCase().compareTo("ASC")==0){
                cq.orderBy(cb.asc(root.get(s.getProperty())));
            }

        });
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
