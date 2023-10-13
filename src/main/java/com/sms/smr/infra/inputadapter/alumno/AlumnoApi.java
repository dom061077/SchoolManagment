package com.sms.smr.infra.inputadapter.alumno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.infra.inputadapter.dto.alumno.AlumnoDtoAfterPost;
import com.sms.smr.infra.inputadapter.dto.alumno.AlumnoDtoPost;
import com.sms.smr.infra.inputadapter.mapper.AlumnoMapper;
import com.sms.smr.infra.inputport.alumno.AlumnoInputPort;
import com.sms.smr.infra.inputport.alumno.AlumnoInputPort;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
//https://auth0.com/blog/how-to-automatically-map-jpa-entities-into-dtos-in-spring-boot-using-mapstruct/
//https://www.toptal.com/spring/spring-boot-oauth2-jwt-rest-protection
@RestController
@RequestMapping(value = "alumno")
@RequiredArgsConstructor
public class AlumnoApi {
    
    
    private final AlumnoInputPort alumnoInputPort;
    
    private final  AlumnoMapper alumnoMapper;
    private static final Logger logger = LoggerFactory.getLogger(AlumnoApi.class);

    @PostMapping(value = "create", produces=MediaType.APPLICATION_JSON_VALUE)
    public AlumnoDtoAfterPost create( @RequestBody @Valid AlumnoDtoPost alumnoDtoPost ) {
        logger.info("DTO recibido: "+alumnoDtoPost.getApellido());
        return alumnoMapper.alumnoToAlumnoDtoAfterPost(alumnoInputPort.createAlumno (alumnoMapper.alumnoPostDtoToAlumno(alumnoDtoPost)));
    }
}
