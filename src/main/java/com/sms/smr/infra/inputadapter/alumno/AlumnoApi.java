package com.sms.smr.infra.inputadapter.alumno;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.alumno.Alumno;
import com.sms.smr.infra.inputport.alumno.AlumnoInputPort;
import com.sms.smr.mapstruct.dtos.AlumnoDtoAfterPost;
import com.sms.smr.mapstruct.dtos.AlumnoDtoPost;

import jakarta.validation.Valid;
//https://auth0.com/blog/how-to-automatically-map-jpa-entities-into-dtos-in-spring-boot-using-mapstruct/
//https://www.toptal.com/spring/spring-boot-oauth2-jwt-rest-protection
@RestController
@RequestMapping(value = "alumno")
public class AlumnoApi {
    @Autowired
    AlumnoInputPort alumnoInputPort;

    @PostMapping(value = "create", produces=MediaType.APPLICATION_JSON_VALUE)
    public AlumnoDtoAfterPost create( @RequestBody @Valid AlumnoDtoPost alumnoDto ) {
        return alumnoInputPort.createAlumno (alumnoDto);
    }
}
