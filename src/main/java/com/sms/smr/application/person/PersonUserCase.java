package com.sms.smr.application.person;

import java.util.List;

import org.hibernate.annotations.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sms.smr.domain.alumno.Alumno;
import com.sms.smr.domain.person.Person;
import com.sms.smr.infra.inputadapter.dto.query.QueryFilterDto;
import com.sms.smr.infra.inputadapter.mapper.PersonMapper;
import com.sms.smr.infra.inputport.person.PersonInputPort;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepository;
import com.sms.smr.infra.outputadapter.mapper.PersonEntityMapper;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class PersonUserCase implements PersonInputPort{

    private static final Logger logger = LoggerFactory.getLogger(PersonUserCase.class);
    @Qualifier("personJpaRepository")
    private final  EntityRepository entityRepository;
    private final PersonEntityMapper personEntityMapper;
    private final QueryRepository queryRepository;


    @Override
    public Person createPerson(Person person) {
        return personEntityMapper.toDomain(entityRepository.save(personEntityMapper.toDbo(person)));
    }

    @Override
    public Person getById(Long personId) {
        return personEntityMapper.toDomain(entityRepository.getById(personId));
    }

    @Override
    public List<Person> getAll(int offset, int limit, List<QueryFilterDto> queryFilters) {
        return queryRepository.getAllAnd(Person.class, offset, limit, queryFilters);
    }
    
}
