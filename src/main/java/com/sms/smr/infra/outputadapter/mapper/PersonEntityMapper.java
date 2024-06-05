package com.sms.smr.infra.outputadapter.mapper;

import java.util.List;
import java.util.Optional;

import org.mapstruct.Mapper; 

import com.sms.smr.domain.Person; 
import com.sms.smr.infra.outputadapter.db.PersonEntity;

@Mapper(
        componentModel = "spring" 
)
public interface PersonEntityMapper{
    
    PersonEntity domainToPersonEntity(Person person);
    
    Person toDomain(PersonEntity personEntity);

    /*
     * @deprecated marcado
     */    
    default Optional<Person> mapToOptionalDomain(Optional<PersonEntity> personEntity){
        return personEntity.map(this::toDomain);
    };

    /*
     * @deprecated marcado
     */
    default Person mapToDomain(Optional<PersonEntity> personEntity){
        return personEntity.map(this::toDomain).orElse(null);
    }

    PersonEntity toDbo(Person person);

    List<Person> getPersons(List<PersonEntity> personEntities);

    //PersonEntity dboToDbo(PersonEntity personEntity);
}
