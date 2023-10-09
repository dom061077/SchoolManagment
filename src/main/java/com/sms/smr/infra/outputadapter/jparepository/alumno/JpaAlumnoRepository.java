package com.sms.smr.infra.outputadapter.jparepository.alumno;

import java.util.List;

import com.sms.smr.infra.outputport.EntityRepository;

public class JpaAlumnoRepository implements EntityRepository{

    @Override
    public <T> T save(T reg) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public <T> T getById(String id, Class<T> clazz) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public <T> List<T> getAll(Class<T> clazz) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}