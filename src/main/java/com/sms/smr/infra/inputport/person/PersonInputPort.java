package com.sms.smr.infra.inputport.person;

import java.util.List;

import com.sms.smr.domain.alumno.Alumno;
import com.sms.smr.domain.person.Person;
import com.sms.smr.infra.inputadapter.dto.query.QueryFilterDto;

public interface PersonInputPort {
   public Person createPerson(Person person);

    public Person getById(Long personId);

    public List<Person> getAll(int offset, int limit, List<QueryFilterDto> queryFilters);    
    
}
