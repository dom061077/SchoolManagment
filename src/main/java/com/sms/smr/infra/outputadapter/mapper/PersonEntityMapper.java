package com.sms.smr.infra.outputadapter.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.sms.smr.domain.Person;
import com.sms.smr.infra.outputadapter.db.PersonEntity;

@Mapper(
        componentModel = "spring"
)
public interface PersonEntityMapper{
    
    Person toDomain(PersonEntity personEntity);

    PersonEntity toDbo(Person person);

    List<Person> getPersons(List<PersonEntity> personEntities);
}
