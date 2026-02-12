package com.sms.smr.infra.outputadapter.jparepository.queryrepository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sms.smr.domain.Provincia;
import com.sms.smr.domain.Role;
import com.sms.smr.infra.exception.InternalServerErrorException;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.db.DepartamentoEntity;
import com.sms.smr.infra.outputadapter.db.LocalidadEntity;
import com.sms.smr.infra.outputadapter.db.MenuRoleEntity;
import com.sms.smr.infra.outputadapter.db.PersonEntity;
import com.sms.smr.infra.outputadapter.db.ProvinciaEntity;
import com.sms.smr.infra.outputadapter.db.StudentEntity;
import com.sms.smr.infra.outputadapter.db.TranslationEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

/* Note:
Root<T> → represents the entity

CriteriaBuilder → used to build conditions (=, like, >, etc.)

Predicate → the actual condition
*/


@Component
public class QueryRepositoryImpl<T> implements QueryRepository<T> {
    @PersistenceContext
    private  EntityManager em;

    private static final Logger logger = LoggerFactory.getLogger(QueryRepositoryImpl.class); 


    private Class<?> getEntityClass(Class<?> clazz) throws Exception {
        if (clazz.equals(PersonEntity.class)==true)
            return PersonEntity.class;
        if (clazz.equals(StudentEntity.class)==true)
            return StudentEntity.class;
        if (clazz.equals(MenuRoleEntity.class)==true)
            return MenuRoleEntity.class;
        if (clazz.equals(TranslationEntity.class) == true)
            return TranslationEntity.class;
        if (clazz.equals(StudentEntity.class) == true)
            return StudentEntity.class;
        if (clazz.equals(LocalidadEntity.class) == true)
            return LocalidadEntity.class;
        if (clazz.equals(ProvinciaEntity.class) == true)
            return ProvinciaEntity.class;
        if (clazz.equals(DepartamentoEntity.class) == true)
            return DepartamentoEntity.class;
        throw new Exception("La clase "+clazz.getName()+ " no está registrada para la query");
    }

    @Override
    public  List<T> getAllOr(Class<T> clazz, int offset, int limit, List<QueryDto> queryFilters) {
        List <T> result = null;

        return result;
    }
    
    @Override
    public   List<T> getAllAnd(Class<T> clazz, int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortingFilters) {
        
        Class<?> entityClass;
        try{
            entityClass = getEntityClass(clazz);
        }catch(Exception e){

            throw new InternalServerErrorException("Clase no registrada para query");
        }

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = cb.createQuery(clazz);
        Root<T> root = criteriaQuery.from(clazz);
        if(sortingFilters!=null)
            addSortings(criteriaQuery, cb, root, sortingFilters);
        
        criteriaQuery.select(root);

        List<Predicate> predicates = getPredicates(clazz,queryFilters,root);
        Predicate predicate = cb.and(predicates.toArray(new Predicate[0]));

        criteriaQuery.where(predicate);
        
        List<T> result =
            em
                .createQuery(criteriaQuery)
                .setMaxResults(limit)
                .setFirstResult(offset)
                .getResultList();



        return result;      
    }

    private void addSortings(CriteriaQuery<T> cq, CriteriaBuilder cb, Root<T> root, List<QueryDto> sortingFilters){
        sortingFilters.forEach(s->{

            if(s.getValue().toUpperCase().compareTo("ASC")==0){
                cq.orderBy(cb.asc(root.get(s.getProperty())));
            }else{
                cq.orderBy(cb.desc(root.get(s.getProperty())));
            }

        });
    }

    private Optional<Object> returnValueFromReflection(Class<?> clazz, String fieldName, String value){
        while(clazz != null){
            try{
                Field field = clazz.getDeclaredField(fieldName);
                if(field.getType().isEnum()){
                    if(field.getType() == Role.class){
                        return Optional.of(Role.valueOf(value));
                    }

                }else{
                    if(field.getType() == boolean.class || field.getType() == Boolean.class){
                        if(value.equalsIgnoreCase("true")){
                            return Optional.of(true);   
                        }else if(value.equalsIgnoreCase("false")){
                            return Optional.of(false);
                        }
                        
                    }
                    return Optional.of(value);
                }
            }catch(NoSuchFieldException e){
                clazz = clazz.getSuperclass();
            }
        }
        return Optional.empty();
    }

    private List<Predicate> getPredicates(Class<?> clazz, List<QueryDto> queryFilters, Root<T> root) {
        logger.info("Ingresando a getPredicates");
        List<Predicate> predicates = new ArrayList<Predicate>();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        if(queryFilters==null)
            return predicates;
        queryFilters.forEach(q->{
            
            String[] splitted = q.getProperty().split(":");
            logger.info("splitted[0]: "+splitted[0]);
  
            if(splitted.length != 2){
                throw new IllegalArgumentException("Parameter type filter is not correct. Example of correct filter --> gt:PropertyName. Item filter: "+String.join(", ",splitted));
            }
            if(q.getValue()!=null){
                if(QueryFilterEnum.valueOf(splitted[1]) == QueryFilterEnum.eq){
                    //predicates.add(cb.equal(root.get(splitted[0]), q.getValue()));
                    predicates.add(cb.equal(root.get(splitted[0]),  (returnValueFromReflection(clazz,splitted[0],q.getValue())).get()));
                   
                }
                if(QueryFilterEnum.valueOf(splitted[1]) == QueryFilterEnum.like){
                    predicates.add(cb.like(cb.upper( root.get(splitted[0])), "%"+q.getValue().toUpperCase()+"%"));
                }
                if(QueryFilterEnum.valueOf(splitted[1]) == QueryFilterEnum.eqin){
                    predicates.add(root.get(splitted[0]).in(List.of(q.getValue().split(","))));
                }
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

    @Override
    public long getCount(Class<T> clazz, List<QueryDto> queryFilters) {
        logger.info("Ingresando a getCount");
        long count = 0;
        Class<?> entityClass;
        try{
            entityClass = getEntityClass(clazz);
        }catch(Exception e){
            logger.warn("No está registrada la clase para la query");
            entityClass = clazz; // fallback to original clazz
        }
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = cb.createQuery(Long.class); 
        Root<T> root = criteriaQuery.from(clazz);
        
        List<Predicate> predicates = getPredicates(entityClass, queryFilters, root);
        Predicate predicate = cb.and(predicates.toArray(new Predicate[0]));
        criteriaQuery.where(predicate);

        criteriaQuery.select(cb.count(root));
        TypedQuery<Long> query = em.createQuery(criteriaQuery);
        count = query.getSingleResult();

        return count;
    }

    @Override
    public List<T> getAllAnd( int offset, int limit, List<QueryDto> queryFilters,
            List<QueryDto> sortingFilters) {
        throw new UnsupportedOperationException("Unimplemented method 'getAllAnd'");
        //return this.getAllAnd((Class<T>) type.getClass(), offset, limit, queryFilters, sortingFilters);
    }
    
}
