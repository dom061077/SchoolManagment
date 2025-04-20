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
public class AlumnoRepository implements EntityRepository<AlumnoEntity>{

    private final SpringDataAlumnoRepository sDataAlumnoRepository;
    
    private final QueryRepository queryRepository;



    @Override
    public AlumnoEntity save(AlumnoEntity reg) {
       
        return  sDataAlumnoRepository.save((AlumnoEntity)reg);
       
    }

    @Override
    public  Optional<AlumnoEntity> getById(Long id) {
        return  sDataAlumnoRepository.findById(id);
    }

    @Override
    public  List<AlumnoEntity> getAll(int offset, int limit, List<QueryDto> queryFilters,List<QueryDto> sorts) {
        //return (List<T>)sDataAlumnoRepository.findAll();
        
        return queryRepository.getAllAnd(AlumnoEntity.class, offset, limit, queryFilters,sorts);
    }

    @Override
    public  Optional<AlumnoEntity> update(Long id, AlumnoEntity reg) {
        // TODO Implement the update logic here
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public long getCount(List<QueryDto> queryFilters) {
        // TODO Auto-generated method stub
        return queryRepository.getCount(AlumnoEntity.class, queryFilters);
    }

    @Override
    public Optional<AlumnoEntity> delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}