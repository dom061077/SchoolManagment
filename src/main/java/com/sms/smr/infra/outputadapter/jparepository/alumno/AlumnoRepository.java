package com.sms.smr.infra.outputadapter.jparepository.alumno;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sms.smr.infra.outputadapter.db.AlumnoEntity;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;

@Component
@Qualifier("alumnoRepository")
@RequiredArgsConstructor
public class AlumnoRepository implements EntityRepository{

    //private final SpringDataAlumnoRepository sDataAlumnoRepository;
    
    private final SpringDataAlumnoRepositoryImpl sDataAlumoRepositoryImpl;



    @Override
    public <T> T save(T reg) {
       
        //return (T) sDataAlumnoRepository.save((AlumnoEntity)reg);
        return null;
    }

    @Override
    public <T> T getById(Long id) {
        
        //return (T) sDataAlumnoRepository.getReferenceById(id);
        return null;
    }

    @Override
    public <T> List<T> getAll(int offset, int limit, HashMap hashMap) {
        return (List<T>)sDataAlumoRepositoryImpl.getAll(offset, limit, hashMap);
    }

}