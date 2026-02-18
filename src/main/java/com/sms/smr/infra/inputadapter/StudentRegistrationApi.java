package com.sms.smr.infra.inputadapter;

import java.util.logging.Logger;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.infra.inputport.BaseInputPort;
import com.sms.smr.infra.outputadapter.db.academic.StudentRegistrationEntity;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/student-registrations")
@PreAuthorize("hasAnyAuthority('ROLE_REALM_preceptor')")
@RequiredArgsConstructor
public class StudentRegistrationApi {
    public final BaseInputPort<StudentRegistrationEntity, Long> studentRegistrationInputPort;
 
    public Logger logger = Logger.getLogger(StudentRegistrationApi.class.getName());

    @PostMapping(value = "create", produces = "application/json")
    @PreAuthorize("hasAnyAuthority('ROLE_RESOUCE_bsn_inscripcion_alumno_create')")
    public StudentRegistrationEntity createStudentRegistration(@RequestBody StudentRegistrationEntity studentRegistration) {
        logger.info("Creating student registration: " + studentRegistration);
        return studentRegistrationInputPort.create(studentRegistration);
    }
    

}
