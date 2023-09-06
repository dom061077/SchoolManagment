package com.sms.smr.mapstruct.mapper;

import org.mapstruct.Mapper;

import com.sms.smr.domain.alumno.Alumno;
import com.sms.smr.mapstruct.dtos.AlumnoDtoPost;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {

        AlumnoDtoPost alumnoToAlumnoDto(Alumno alumnoDto);

        Alumno alumnoDtoToAlumno(AlumnoDtoPost alumno);
    
}
