package com.sms.smr.mapstruct.mapper;

import org.mapstruct.Mapper;

import com.sms.smr.domain.alumno.Alumno;
import com.sms.smr.mapstruct.dtos.AlumnoDto;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {

        AlumnoDto alumnoToAlumnoDto(Alumno alumnoDto);

        Alumno alumnoDtoToAlumno(AlumnoDto alumno);
    
}
