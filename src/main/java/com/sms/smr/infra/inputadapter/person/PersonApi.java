package com.sms.smr.infra.inputadapter.person;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;


import com.sms.smr.domain.person.Person;
import com.sms.smr.infra.inputadapter.dto.person.PersonDto;
import com.sms.smr.infra.inputadapter.mapper.PersonMapper;
import com.sms.smr.infra.inputport.person.PersonInputPort;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping(value="person", method=RequestMethod.GET)
@RequiredArgsConstructor
public class PersonApi {
    private final PersonInputPort personInputPort;
    private final PersonMapper personMapper;
    private static final Logger logger = LoggerFactory.getLogger(PersonApi.class); 


    public PersonDto create(@RequestBody @Valid PersonDto personDto){
       return personMapper.personToPersonDto(personInputPort.createPerson(personMapper.personDtoToPerson(personDto)));
      
    }

}
