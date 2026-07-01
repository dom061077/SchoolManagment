package com.sms.smr.infra.output.persistence.db;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.Person;
import com.sms.smr.infra.output.persistence.BaseRepository;

@Repository
public class PersonPersistenceAdapter extends BaseRepository<Person, Long, PersonEntity, PersonJpaRepository> {

    public PersonPersistenceAdapter(PersonJpaRepository repository, PersonEntityMapper mapper) {
        super(repository, mapper, PersonEntity.class);
    }
}
