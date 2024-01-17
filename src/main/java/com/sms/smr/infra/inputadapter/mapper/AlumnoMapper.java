package com.sms.smr.infra.inputadapter.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.sms.smr.infra.inputadapter.dto.AlumnoDto;
import com.sms.smr.infra.inputadapter.dto.alumno.AlumnoDtoAfterPost;
import com.sms.smr.domain.Alumno;

@Mapper(
        componentModel = "spring"
)
public interface AlumnoMapper {

        AlumnoDto alumnoToAlumnoDto(Alumno alumno);

        Alumno alumnoPostDtoToAlumno(AlumnoDto alumnoDtoPost);

        AlumnoDtoAfterPost alumnoToAlumnoDtoAfterPost(Alumno alumno);

        List<AlumnoDto> getAlumnoDtos(List<Alumno> alumnos);
    
}
