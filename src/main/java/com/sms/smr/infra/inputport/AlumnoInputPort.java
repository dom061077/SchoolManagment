package com.sms.smr.infra.inputport;

import java.util.List;

import com.sms.smr.domain.Alumno;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;

public interface AlumnoInputPort {

    public Alumno createAlumno(Alumno alumnoDtoPost);

    public Alumno getById(Long alumnoId);

    public QueryResult<Alumno> getAll(int offset, int limit, List<QueryDto> queryFilters,List<QueryDto> sorts);    
}
