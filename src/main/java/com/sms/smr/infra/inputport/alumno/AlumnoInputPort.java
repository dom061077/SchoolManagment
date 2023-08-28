package com.sms.smr.infra.inputport.alumno;

import com.sms.smr.domain.alumno.Alumno;
import java.util.List;

public interface AlumnoInputPort {
    public Alumno createAlumno(String name, String country);

    public Alumno getById(Long alumnoId);

    public List<Alumno> getAll();    
}
