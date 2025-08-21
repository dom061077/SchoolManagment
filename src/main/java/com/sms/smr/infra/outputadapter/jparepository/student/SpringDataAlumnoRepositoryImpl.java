package com.sms.smr.infra.outputadapter.jparepository.student;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sms.smr.infra.outputadapter.db.StudentEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;


/* Esta clase está deprecated */
@Component
public class SpringDataAlumnoRepositoryImpl/*  implements SpringDataAlumnoRepository*/{
    @PersistenceContext
    private  EntityManager em;



    //@Override
    public <T> List<T> getAll(int offset, int limit,Map<T,Object> params){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<StudentEntity> criteriaQuery = cb.createQuery(StudentEntity.class);
        Root<StudentEntity> root = criteriaQuery.from(StudentEntity.class);
        criteriaQuery.select(root);

    

        List<StudentEntity> result =
            em
                .createQuery(criteriaQuery)
                .setMaxResults(limit)
                .setFirstResult(offset)
                .getResultList();
    
        return (List<T>) result;        
    }



    
}
