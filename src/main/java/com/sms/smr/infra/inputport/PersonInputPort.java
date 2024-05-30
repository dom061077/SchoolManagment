package com.sms.smr.infra.inputport;

import java.util.List;


import com.sms.smr.domain.Person;
import com.sms.smr.infra.inputadapter.dto.query.QueryFilterDto;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;

public interface PersonInputPort {
   public Person createPerson(Person person);

    public Person getById(Long personId);

    public QueryResult<Person> getAll(int offset, int limit, List<QueryFilterDto> queryFilters, List<QueryFilterDto> sortings);    
    

    
}
