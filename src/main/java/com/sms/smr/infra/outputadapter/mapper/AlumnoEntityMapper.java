package com.sms.smr.infra.outputadapter.mapper;

import org.mapstruct.Mapper;

import com.sms.smr.domain.alumno.Alumno;
import com.sms.smr.infra.outputadapter.db.AlumnoEntity;

@Mapper(
        componentModel = "spring"
)

public interface AlumnoEntityMapper {

    Alumno toDomain(AlumnoEntity alumnoEntity);

    AlumnoEntity toDbo(Alumno alumno);
    
}
