package com.sms.smr.infra.outputadapter.jparepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
      
import org.springframework.data.repository.CrudRepository;

import com.sms.smr.domain.alumno.Alumno;
import com.sms.smr.infra.outputport.EntityRepository;

public class AlumnoJpaRepository implements EntityRepository {
    
    @Autowired
    CrudRepository crudRepository;

    

    public <T> T save(T reg){
        return (T) crudRepository.save(reg);
    }


    public <T> T getById( String id, Class<T> clazz ){
        return (T) crudRepository.findById(id);
    }

    public <T> List<T> getAll( Class<T> clazz ){
        return (List)crudRepository.findAll();
    }   
}
