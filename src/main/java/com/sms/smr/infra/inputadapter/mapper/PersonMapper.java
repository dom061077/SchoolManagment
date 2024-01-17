package com.sms.smr.infra.inputadapter.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.sms.smr.domain.Person;
import com.sms.smr.infra.inputadapter.dto.PersonDto;


@Mapper(
        componentModel = "spring"
)
public interface PersonMapper{ 

    PersonDto personToPersonDto(Person person);

    Person personDtoToPerson(PersonDto personDto);

   
    
}
