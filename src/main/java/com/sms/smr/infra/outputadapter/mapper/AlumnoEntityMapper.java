package com.sms.smr.infra.outputadapter.mapper;

import com.sms.smr.domain.alumno.Alumno;
import com.sms.smr.infra.outputadapter.db.AlumnoEntity;

public interface AlumnoEntityMapper {

    Alumno toDomain(AlumnoEntity alumnoEntity);

    AlumnoEntity toDbo(Alumno alumno);
    
}
