package com.sms.smr.infra.outputadapter.jparepository.person;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.sms.smr.infra.inputadapter.dto.query.QueryFilterDto;
import com.sms.smr.infra.outputadapter.db.AlumnoEntity;
import com.sms.smr.infra.outputadapter.db.PersonEntity;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepository;
import com.sms.smr.infra.outputadapter.mapper.PersonEntityMapper;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Component(value = "personRepository")
public class PersonRepository implements EntityRepository {

    private final SpringDataPersonRepository sDataPersonRepository;

    private final QueryRepository queryRepository;

    private final PersonEntityMapper personEntityMapper;


    @Override
    public <T> T save(T reg) {
        return (T)sDataPersonRepository.save((PersonEntity)reg);

    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getById(Long id) {
        return (T)sDataPersonRepository.findById(id).orElseThrow();
    }

    @Override
    public <T> List<T> getAll(int offset, int limit, List<QueryFilterDto> queryFilters,List<QueryFilterDto> sortFilters) {
        // TODO Auto-generated method stub
        return (List<T>) queryRepository.getAllAnd(PersonEntity.class, offset, limit, queryFilters, sortFilters);
    }

    @Override
    public <T> T update(Long id, T reg) {
        PersonEntity personEntity = sDataPersonRepository.findById(id).orElseThrow();
        
        BeanUtils.copyProperties(reg, personEntity,"id");

        return (T)sDataPersonRepository.save(personEntity); 
    }
    
}
