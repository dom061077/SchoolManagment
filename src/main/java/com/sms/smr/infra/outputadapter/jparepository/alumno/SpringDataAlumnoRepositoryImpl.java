package com.sms.smr.infra.outputadapter.jparepository.alumno;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sms.smr.infra.outputadapter.db.AlumnoEntity;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepository;

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
        CriteriaQuery<AlumnoEntity> criteriaQuery = cb.createQuery(AlumnoEntity.class);
        Root<AlumnoEntity> root = criteriaQuery.from(AlumnoEntity.class);
        criteriaQuery.select(root);

    

        List<AlumnoEntity> result =
            em
                .createQuery(criteriaQuery)
                .setMaxResults(limit)
                .setFirstResult(offset)
                .getResultList();
    
        return (List<T>) result;        
    }



    
}
