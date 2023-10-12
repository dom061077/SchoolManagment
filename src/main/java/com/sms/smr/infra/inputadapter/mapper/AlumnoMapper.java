package com.sms.smr.infra.inputadapter.mapper;

import org.mapstruct.Mapper;

import com.sms.smr.domain.alumno.Alumno;
import com.sms.smr.infra.inputadapter.dto.alumno.AlumnoDtoAfterPost;
import com.sms.smr.infra.inputadapter.dto.alumno.AlumnoDtoPost;

@Mapper(
        componentModel = "spring"
)
public interface AlumnoMapper {

        AlumnoDtoPost alumnoToAlumnoPostDto(Alumno alumno);

        Alumno alumnoPostDtoToAlumno(AlumnoDtoPost alumnoDtoPost);

        AlumnoDtoAfterPost alumnoToAlumnoDtoAfterPost(Alumno alumno);
    
}
