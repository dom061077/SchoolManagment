package com.sms.smr.infra.input.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.model.StudentRegistration;
import com.sms.smr.domain.ports.in.BaseUseCase;

@RestController
@RequestMapping("/api/v1/student-registrations")
@PreAuthorize("hasAnyAuthority('ROLE_REALM_preceptor')")
public class StudentRegistrationApi extends BaseApi<StudentRegistration, Long> {

    public StudentRegistrationApi(BaseUseCase<StudentRegistration, Long> studentRegistrationInputPort) {
        super(studentRegistrationInputPort);
    }
}
