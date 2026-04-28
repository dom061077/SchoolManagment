package com.sms.smr.infra.input.rest;

import java.util.logging.Logger;

import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.model.StudentRegistration;
import com.sms.smr.domain.ports.in.BaseUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/v1/student-registrations")
@PreAuthorize("hasAnyAuthority('ROLE_REALM_preceptor')")
@RequiredArgsConstructor
public class StudentRegistrationApi {
    public final BaseUseCase<StudentRegistration, Long> studentRegistrationInputPort;
 
    public Logger logger = Logger.getLogger(StudentRegistrationApi.class.getName());

    @PostMapping(value = "create", produces = "application/json")
    //@PreAuthorize("hasAnyAuthority('ROLE_RESOUCE_bsn_inscripcion_alumno_create')")
    public StudentRegistration createStudentRegistration(@RequestBody StudentRegistration studentRegistration) {
        logger.info("Creating student registration: " + studentRegistration);
        return studentRegistrationInputPort.create(studentRegistration);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public StudentRegistration getById(@PathVariable Long id) {
        logger.info("Getting student registration: "+id);
        return studentRegistrationInputPort.getById(id).get();
    }

    @GetMapping(value = "list", produces = "application/json")
    //@PreAuthorize("hasAnyAuthority('ROLE_RESOUCE_bsn_inscripcion_alumno_read')")
    public Page<StudentRegistration> getAll(@RequestParam int offset, @RequestParam int limit
        ,@RequestParam String qfilters, @RequestParam String sorts,@RequestParam String loperator) {
        logger.info("Getting all student registrations with offset: " + offset + ", limit: " + limit);
        return studentRegistrationInputPort.getAll(offset, limit, qfilters, sorts, loperator);
    }
    
    @DeleteMapping(value = "/{id}", produces = "application/json")
    //@PreAuthorize("hasAnyAuthority('ROLE_RESOUCE_bsn_inscripcion_alumno_delete')")
    public boolean deleteStudentRegistration(@PathVariable Long id) {
        logger.info("Deleting student registration with id: " + id);
        return studentRegistrationInputPort.delete(id);
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    //@PreAuthorize("hasAnyAuthority('ROLE_RESOUCE_bsn_inscripcion_alumno_update')")
    public StudentRegistration updateStudentRegistration(@PathVariable Long id, @RequestBody @Valid StudentRegistration studentRegistration) {
        logger.info("Updating student registration with id: " + id);
        return studentRegistrationInputPort.update(id, studentRegistration);
    }

}
