package com.sms.smr.infra.outputadapter.jparepository.alumno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.db.AlumnoEntity;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepository;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Component(value = "alumnoRepository")
public class AlumnoRepository implements EntityRepository{

    private final SpringDataAlumnoRepository sDataAlumnoRepository;
    
    private final QueryRepository queryRepository;



    @Override
    public <T> T save(T reg) {
       
        return (T) sDataAlumnoRepository.save((AlumnoEntity)reg);
       
    }

    @Override
    public <T> Optional<T> getById(Long id) {
        return (Optional<T>) sDataAlumnoRepository.findById(id);
    }

    @Override
    public <T> List<T> getAll(int offset, int limit, List<QueryDto> queryFilters,List<QueryDto> sorts) {
        //return (List<T>)sDataAlumnoRepository.findAll();
        
        return (List<T> )queryRepository.getAllAnd(AlumnoEntity.class, offset, limit, queryFilters,sorts);
    }

    @Override
    public <T> Optional<T> update(Long id, T reg) {
        // TODO Implement the update logic here
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public long getCount(List<QueryDto> queryFilters) {
        // TODO Auto-generated method stub
        return queryRepository.getCount(AlumnoEntity.class, queryFilters);
    }

}