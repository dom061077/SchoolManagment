package com.sms.smr.application;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sms.smr.domain.Person;
import com.sms.smr.infra.inputadapter.dto.query.QueryFilterDto;
import com.sms.smr.infra.inputport.PersonInputPort;
import com.sms.smr.infra.outputadapter.db.PersonEntity;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepository;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;
import com.sms.smr.infra.outputadapter.mapper.PersonEntityMapper;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class PersonUserCase implements PersonInputPort{

    private static final Logger logger = LoggerFactory.getLogger(PersonUserCase.class);
    @Qualifier(value="personRepository")
    @Autowired
    private final  EntityRepository entityRepository;
    private final PersonEntityMapper personEntityMapper;
    private final QueryRepository queryRepository;

    /*public PersonUserCase(QueryRepository queryRepository, PersonEntityMapper personEntityMapper,@Qualifier(value="personJpaRepository") EntityRepository entityRepository){
        this.personEntityMapper = personEntityMapper;
        this.entityRepository = entityRepository;
        this.queryRepository = queryRepository;
    }*/

    @Override
    public Person createPerson(Person person) {
        return personEntityMapper.toDomain(entityRepository.save(personEntityMapper.toDbo(person)));
    }

    @Override
    public Person getById(Long personId) {
        return personEntityMapper.toDomain(entityRepository.getById(personId));
    }

    @Override
    public  QueryResult getAll(int offset, int limit, List<QueryFilterDto> queryFilters, List<QueryFilterDto> sorts) {
        QueryResult qResult = queryRepository.getAllAnd(PersonEntity.class, offset, limit, queryFilters, sorts);
        qResult.setData(personEntityMapper.getPersons(qResult.getData()));
        return qResult;
    }
    
}
