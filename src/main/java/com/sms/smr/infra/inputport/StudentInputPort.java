package com.sms.smr.infra.inputport;

import java.util.List;
import java.util.Optional;

import com.sms.smr.domain.Student;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;



public interface StudentInputPort {
    Student create(Student student);
    Optional<Student> getById(Long id);
    QueryResult<Student> getAll(int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortings);
    Student update(Long id, Student student);
    boolean delete(Long id, Student student);
}
