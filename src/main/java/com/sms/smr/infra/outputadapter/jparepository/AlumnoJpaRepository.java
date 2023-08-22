package com.sms.smr.infra.outputadapter.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.smr.domain.alumno.Alumno;
import com.sms.smr.infra.outputport.EntityRepository;

public class AlumnoJpaRepository implements EntityRepository {

    private final JpaRepository jpaRep;

    public <T> T save(T reg){
        return jpaRep.save((Alumno)reg);
    }


    public <T> T getById( String id, Class<T> clazz ){

    }

    public <T> List<T> getAll( Class<T> clazz ){
        
    }   
}
