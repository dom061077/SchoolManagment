package com.sms.smr.infra.ouput.persistence.db;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.Person;
import com.sms.smr.domain.ports.out.PersonQueryPersistenceOutputPort;
import com.sms.smr.infra.ouput.persistence.BaseSpecificationBuilder;
import com.sms.smr.infra.ouput.persistence.QueryBaseRepository;

@Repository
public class PersonQueryAdapter extends QueryBaseRepository<Person, Long, PersonEntity, PersonJpaRepository> implements PersonQueryPersistenceOutputPort {

    public PersonQueryAdapter(PersonJpaRepository repository, PersonEntityMapper mapper) {
        super(repository, new BaseSpecificationBuilder<PersonEntity>(), mapper);
    }
}
