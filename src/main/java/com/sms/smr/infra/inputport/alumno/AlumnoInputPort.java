package com.sms.smr.infra.inputport.alumno;

import com.sms.smr.domain.alumno.Alumno;
import com.sms.smr.mapstruct.dtos.AlumnoDtoAfterPost;

import java.util.List;

public interface AlumnoInputPort {
    public AlumnoDtoAfterPost createAlumno(String name, String country);

    public Alumno getById(Long alumnoId);

    public List<Alumno> getAll();    
}
