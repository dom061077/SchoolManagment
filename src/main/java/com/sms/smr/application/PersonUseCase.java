package com.sms.smr.application;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.sms.smr.domain.Person;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.inputport.BaseInputPort;
import com.sms.smr.infra.outputadapter.db.PersonEntity;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepository;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;
import com.sms.smr.infra.outputadapter.mapper.PersonEntityMapper;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;


@Component(value = "personUseCase")
@RequiredArgsConstructor
public class PersonUseCase implements BaseInputPort<Person>{

    private static final Logger logger = LoggerFactory.getLogger(PersonUseCase.class);
    @Qualifier(value="personRepository")
    private final  EntityRepository<PersonEntity> entityRepository;
    private final PersonEntityMapper personEntityMapper;
    private final QueryRepository queryRepository;


    @Override
    public Person create(Person person) {
        return personEntityMapper.toDomain(entityRepository.save(personEntityMapper.toDbo(person)));
    }

    @Override
    public Optional<Person> getById(Long personId) {
        //return personEntityMapper.mapToDomain( Optional.of(entityRepository.getById(personId)));
        
        return entityRepository.getById(personId)
                .map(personEntity -> personEntityMapper.toDomain((PersonEntity) personEntity));
    }

    @Override
    public  QueryResult<Person> getAll(int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sorts) {
        QueryResult<Person> qResult = new QueryResult<Person>();            

        qResult.setData(personEntityMapper.getPersons(queryRepository.getAllAnd(PersonEntity.class, offset, limit, queryFilters, sorts)));
        long count = entityRepository.getCount(queryFilters);
        qResult.setTotal(count);

        return qResult;
    }   

    @Override
    public Optional<Person> update(Long personId, Person person) {
        // TODO Auto-generated method stub
        return entityRepository.update(personId, personEntityMapper.toDbo(person))
                .map(personEntityMapper::toDomain);
    }

    @Override
    public boolean delete(Long id) {
        // TODO Auto-generated method stub
        Optional<PersonEntity> deletedPerson = entityRepository.delete(id);
        if(deletedPerson.isEmpty())
            return false;
        return true;
    }



    
}
