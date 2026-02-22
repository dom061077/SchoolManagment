package com.sms.smr.infra.outputadapter.repositoryadapter.person;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.sms.smr.domain.Person;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.db.PersonEntity;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryRepository;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Primary
//@Component(value = "personRepository")
public class PersonRepository implements EntityRepository<PersonEntity> {

    private final SpringDataPersonRepository sDataPersonRepository;

    private final QueryRepository<PersonEntity, Long> queryRepository;

    @Override
    public PersonEntity save(PersonEntity reg) {
        return sDataPersonRepository.save((PersonEntity)reg);
    }


    @Override
    public Optional<PersonEntity> getById(Long id) {
        return (Optional<PersonEntity>) sDataPersonRepository.findById(id);
    }

    @Override
    public List<PersonEntity> getAll(int offset, int limit, List<QueryDto> queryFilters,List<QueryDto> sortFilters) {

        return  queryRepository.getAllAnd(PersonEntity.class, offset, limit, queryFilters, sortFilters);
    }

    @Override
    public Optional<PersonEntity> update(Long id, PersonEntity reg) {
        Optional<PersonEntity> personOptionalEntity = sDataPersonRepository.findById(id);
        
        BeanUtils.copyProperties(reg, personOptionalEntity.get(),"id");

        return (Optional<PersonEntity>) Optional.of(sDataPersonRepository.save(personOptionalEntity.get())); 
    }

    @Override
    public long getCount(List<QueryDto> queryFilters) {
        return queryRepository.getCount(PersonEntity.class, queryFilters);
    }

    @Override
    public Optional<PersonEntity> delete(Long id) {
        Optional<PersonEntity> personOptionalEntity = sDataPersonRepository.findById(id);
        if (personOptionalEntity.isPresent()) {
            personOptionalEntity.get().setDeleted(true);
            sDataPersonRepository.save(personOptionalEntity.get());

            
        } else {
            return Optional.empty();
        }
        
        return personOptionalEntity;
    }
    
}
