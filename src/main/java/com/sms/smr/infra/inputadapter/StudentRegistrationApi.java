package com.sms.smr.infra.inputadapter;

import java.util.logging.Logger;

import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.StudentRegistration;
import com.sms.smr.infra.inputport.BaseInputPort;
import com.sms.smr.infra.outputadapter.db.academic.StudentRegistrationEntity;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/student-registrations")
@PreAuthorize("hasAnyAuthority('ROLE_REALM_preceptor')")
@RequiredArgsConstructor
public class StudentRegistrationApi {
    public final BaseInputPort<StudentRegistration, Long> studentRegistrationInputPort;
 
    public Logger logger = Logger.getLogger(StudentRegistrationApi.class.getName());

    @PostMapping(value = "create", produces = "application/json")
    //@PreAuthorize("hasAnyAuthority('ROLE_RESOUCE_bsn_inscripcion_alumno_create')")
    public StudentRegistration createStudentRegistration(@RequestBody StudentRegistration studentRegistration) {
        logger.info("Creating student registration: " + studentRegistration);
        return studentRegistrationInputPort.create(studentRegistration);
    }

    @GetMapping(value = "list", produces = "application/json"
    //@PreAuthorize("hasAnyAuthority('ROLE_RESOUCE_bsn_inscripcion_alumno_read')")
    )
    public Page<StudentRegistration> getAll(@RequestParam int offset, @RequestParam int limit
        ,@RequestParam String qfilters, @RequestParam String sorts,@RequestParam String loperator) {
        logger.info("Getting all student registrations with offset: " + offset + ", limit: " + limit);
        return studentRegistrationInputPort.getAll(offset, limit, qfilters, sorts, loperator);
    }
    

}
