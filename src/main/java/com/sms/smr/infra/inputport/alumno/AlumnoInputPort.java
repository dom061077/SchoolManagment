package com.sms.smr.infra.inputport.alumno;

import com.sms.smr.domain.alumno.Alumno;
import com.sms.smr.infra.inputadapter.dto.query.QueryFilter;

import java.util.HashMap;
import java.util.List;

public interface AlumnoInputPort {

    public Alumno createAlumno(Alumno alumnoDtoPost);

    public Alumno getById(Long alumnoId);

    public List<Alumno> getAll(int offset, int limit, List<QueryFilter> queryFilters);    
}
