package com.sms.smr.infra.inputadapter.alumno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.infra.inputport.alumno.AlumnoInputPort;
//https://auth0.com/blog/how-to-automatically-map-jpa-entities-into-dtos-in-spring-boot-using-mapstruct/
@RestController
@RequestMapping(value = "alumno")
public class AlumnoApi {
    @Autowired
    AlumnoInputPort alumnoInputPort;
}
