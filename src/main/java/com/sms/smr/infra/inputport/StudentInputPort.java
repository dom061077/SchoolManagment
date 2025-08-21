package com.sms.smr.infra.inputport;

import java.util.List;

import com.sms.smr.domain.Student;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;

public interface StudentInputPort {

    public Student createAlumno(Student alumnoDtoPost);

    public Student getById(Long alumnoId);

    public QueryResult<Student> getAll(int offset, int limit, List<QueryDto> queryFilters,List<QueryDto> sorts);    
}
