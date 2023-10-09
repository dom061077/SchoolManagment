package com.sms.smr.application.alumno;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sms.smr.domain.alumno.Alumno;
import com.sms.smr.infra.inputadapter.dto.alumno.AlumnoDtoAfterPost;
import com.sms.smr.infra.inputadapter.dto.alumno.AlumnoDtoPost;
import com.sms.smr.infra.inputport.alumno.AlumnoInputPort;

@Component
public class AlumnoUseCase implements AlumnoInputPort{

    @Override
    public AlumnoDtoAfterPost createAlumno(AlumnoDtoPost alumnoDtoPost) {
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
