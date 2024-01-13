package com.sms.smr.infra.outputadapter.jparepository.alumno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.sms.smr.infra.inputadapter.dto.query.QueryFilterDto;
import com.sms.smr.infra.outputadapter.db.AlumnoEntity;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepository;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
//@Primary
@Component(value = "alumnoRepository")
public class AlumnoRepository implements EntityRepository{

    private final SpringDataAlumnoRepository sDataAlumnoRepository;
    
    private final QueryRepository queryRepository;



    @Override
    public <T> T save(T reg) {
       
        return (T) sDataAlumnoRepository.save((AlumnoEntity)reg);
       
    }

    @Override
    public <T> T getById(Long id) {
        
        return (T) sDataAlumnoRepository.getReferenceById(id);
        //return null;
    }

    @Override
    public <T> List<T> getAll(int offset, int limit, List<QueryFilterDto> queryFilters) {
        //return (List<T>)sDataAlumnoRepository.findAll();
        
        return (List<T> )queryRepository.getAllAnd(AlumnoEntity.class, offset, limit, queryFilters);
    }

}