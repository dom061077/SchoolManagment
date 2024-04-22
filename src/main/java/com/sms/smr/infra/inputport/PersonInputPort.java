package com.sms.smr.infra.inputport;

import java.util.List;

import com.sms.smr.domain.Alumno;
import com.sms.smr.domain.Person;
import com.sms.smr.infra.inputadapter.dto.query.QueryFilterDto;

public interface PersonInputPort {
   public Person createPerson(Person person);

    public Person getById(Long personId);

    public List<Person> getAll(int offset, int limit, List<QueryFilterDto> queryFilters, List<QueryFilterDto> sortings);    
    
}
