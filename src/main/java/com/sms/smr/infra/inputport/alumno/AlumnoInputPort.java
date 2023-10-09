package com.sms.smr.infra.inputport.alumno;

import com.sms.smr.domain.alumno.Alumno;
import com.sms.smr.infra.inputadapter.dto.alumno.AlumnoDtoAfterPost;
import com.sms.smr.infra.inputadapter.dto.alumno.AlumnoDtoPost;

import java.util.List;

public interface AlumnoInputPort {

    public AlumnoDtoAfterPost createAlumno(AlumnoDtoPost alumnoDtoPost);

    public Alumno getById(Long alumnoId);

    public List<Alumno> getAll();    
}
