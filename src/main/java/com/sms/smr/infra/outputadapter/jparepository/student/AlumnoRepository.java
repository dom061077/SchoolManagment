package com.sms.smr.infra.outputadapter.jparepository.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.db.StudentEntity;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepository;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Component(value = "alumnoRepository")
public class AlumnoRepository implements EntityRepository<StudentEntity>{

    private final SpringDataAlumnoRepository sDataAlumnoRepository;
    
    private final QueryRepository queryRepository;



    @Override
    public StudentEntity save(StudentEntity reg) {
       
        return  sDataAlumnoRepository.save((StudentEntity)reg);
       
    }

    @Override
    public  Optional<StudentEntity> getById(Long id) {
        return  sDataAlumnoRepository.findById(id);
    }

    @Override
    public  List<StudentEntity> getAll(int offset, int limit, List<QueryDto> queryFilters,List<QueryDto> sorts) {
        //return (List<T>)sDataAlumnoRepository.findAll();
        
        return queryRepository.getAllAnd(StudentEntity.class, offset, limit, queryFilters,sorts);
    }

    @Override
    public  Optional<StudentEntity> update(Long id, StudentEntity reg) {
        // TODO Implement the update logic here
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public long getCount(List<QueryDto> queryFilters) {
        // TODO Auto-generated method stub
        return queryRepository.getCount(StudentEntity.class, queryFilters);
    }

    @Override
    public Optional<StudentEntity> delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}