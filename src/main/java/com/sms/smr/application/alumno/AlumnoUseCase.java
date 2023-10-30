package com.sms.smr.application.alumno;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sms.smr.domain.alumno.Alumno;
import com.sms.smr.infra.inputadapter.alumno.AlumnoApi;
import com.sms.smr.infra.inputport.alumno.AlumnoInputPort;
import com.sms.smr.infra.outputadapter.mapper.AlumnoEntityMapper;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AlumnoUseCase implements AlumnoInputPort{
    private static final Logger logger = LoggerFactory.getLogger(AlumnoApi.class);
    private final @Qualifier("alumnoRepository") EntityRepository entityRepository;
    
    private final  AlumnoEntityMapper alumnoEntMapper;

    @Override
    public Alumno createAlumno(Alumno alumno) {
        logger.info("Apellido de alumno: "+alumno.getApellido());
        return alumnoEntMapper.toDomain(entityRepository.save(alumnoEntMapper.toDbo(alumno)));
    }

    @Override
    public List<Alumno> getAll(int offset, int limit, HashMap hashMap) {
    
        return alumnoEntMapper.getAlumnos(entityRepository.getAll(offset, limit,  hashMap));
    }

    @Override
    public Alumno getById(Long alumnoId) {
        
        return alumnoEntMapper.toDomain(entityRepository.getById(alumnoId));
    }
    
}
