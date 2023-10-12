package com.sms.smr.application.alumno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sms.smr.domain.alumno.Alumno;
import com.sms.smr.infra.inputadapter.dto.alumno.AlumnoDtoAfterPost;
import com.sms.smr.infra.inputadapter.dto.alumno.AlumnoDtoPost;
import com.sms.smr.infra.inputport.alumno.AlumnoInputPort;
import com.sms.smr.infra.outputadapter.jparepository.alumno.SpringDataAlumnoRepository;
import com.sms.smr.infra.outputadapter.mapper.AlumnoEntityMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component

public class AlumnoUseCase implements AlumnoInputPort{

    private  SpringDataAlumnoRepository sdAlumnoRepository;
    @Autowired
    private AlumnoEntityMapper alumnoEntMapper;

    @Override
    public Alumno createAlumno(Alumno alumno) {
        
        return alumnoEntMapper.toDomain(sdAlumnoRepository.save(alumnoEntMapper.toDbo(alumno)));
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
