package com.sms.smr.application.alumno;

import java.util.List;

import com.sms.smr.domain.alumno.Alumno;
import com.sms.smr.infra.inputport.alumno.AlumnoInputPort;
import com.sms.smr.mapstruct.dtos.AlumnoDtoPost;

public class AlumnoUseCase implements AlumnoInputPort{

    @Override
    public AlumnoDtoPost createAlumno(String name, String country) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Alumno> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Alumno getById(Long alumnoId) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
