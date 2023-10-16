package com.sms.smr.infra.outputadapter.jparepository.alumno;

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

    private final SpringDataAlumnoRepository sDataAlumnoRepository;

    @Override
    public <T> T save(T reg) {
        // TODO Auto-generated method stub
        return (T) sDataAlumnoRepository.save((AlumnoEntity)reg);
    }

    @Override
    public <T> T getById(Long id) {
        
        return (T) sDataAlumnoRepository.getReferenceById(id);
    }

    @Override
    public <T> List<T> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}