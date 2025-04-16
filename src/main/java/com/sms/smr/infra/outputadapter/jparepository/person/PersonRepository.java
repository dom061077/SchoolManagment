package com.sms.smr.infra.outputadapter.jparepository.person;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
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
    public <T>  T save(T reg) {
        return (T) sDataPersonRepository.save((PersonEntity)reg);

    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> Optional<T> getById(Long id) {
        return (Optional<T>) sDataPersonRepository.findById(id);
    }

    @Override
    public <T>  List<T> getAll(int offset, int limit, List<QueryDto> queryFilters,List<QueryDto> sortFilters) {
        // TODO Auto-generated method stub
        return  (List<T>)queryRepository.getAllAnd(PersonEntity.class, offset, limit, queryFilters, sortFilters);
    }

    @Override
    public <T> Optional<T> update(Long id, T reg) {
        Optional<PersonEntity> personOptinoalEntity = sDataPersonRepository.findById(id);
        
        BeanUtils.copyProperties(reg, personOptinoalEntity.get(),"id");

        return (Optional<T>) Optional.of(sDataPersonRepository.save(personOptinoalEntity.get())); 
    }

    @Override
    public long getCount(List<QueryDto> queryFilters) {
        // TODO Auto-generated method stub
        return queryRepository.getCount(PersonEntity.class, queryFilters);
    }
    
}
