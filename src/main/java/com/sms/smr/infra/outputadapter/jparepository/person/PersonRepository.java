package com.sms.smr.infra.outputadapter.jparepository.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.sms.smr.infra.inputadapter.dto.query.QueryFilterDto;
import com.sms.smr.infra.outputadapter.db.AlumnoEntity;
import com.sms.smr.infra.outputadapter.db.PersonEntity;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepository;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Component(value="personRepository")
public class PersonRepository implements EntityRepository {

    private final SpringDataPersonRepository sDataPersonRepository;

    private final QueryRepository queryRepository;


    @Override
    public <T> T save(T reg) {
        if(reg instanceof PersonEntity)
            return (T)sDataPersonRepository.save((PersonEntity)reg);
        else
            return null;
    }

    @Override
    public <T> T getById(Long id) {
        return (T)sDataPersonRepository.getReferenceById(id);
    }

    @Override
    public <T> List<T> getAll(int offset, int limit, List<QueryFilterDto> queryFilters) {
        // TODO Auto-generated method stub
        return (List<T>) queryRepository.getAllAnd(AlumnoEntity.class, offset, limit, queryFilters);
    }
    
}
