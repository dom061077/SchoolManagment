package com.sms.smr.infra.outputadapter.jparepository.person;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.sms.smr.infra.inputadapter.dto.query.QueryFilterDto;
import com.sms.smr.infra.outputadapter.db.PersonEntity;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepository;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Primary
@Component(value = "personRepository")
public class PersonRepository implements EntityRepository {

    private final SpringDataPersonRepository sDataPersonRepository;

    private final QueryRepository queryRepository;

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

    @Override
    public long getCount(List<QueryFilterDto> queryFilters) {
        // TODO Auto-generated method stub
        return queryRepository.getCount(PersonEntity.class, queryFilters);
    }
    
}
