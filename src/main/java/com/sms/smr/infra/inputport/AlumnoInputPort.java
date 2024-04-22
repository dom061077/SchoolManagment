package com.sms.smr.infra.inputport;

import com.sms.smr.domain.Alumno;
import com.sms.smr.infra.inputadapter.dto.query.QueryFilterDto;

import java.util.HashMap;
import java.util.List;

public interface AlumnoInputPort {

    public Alumno createAlumno(Alumno alumnoDtoPost);

    public Alumno getById(Long alumnoId);

    public List<Alumno> getAll(int offset, int limit, List<QueryFilterDto> queryFilters,List<QueryFilterDto> sorts);    
}
