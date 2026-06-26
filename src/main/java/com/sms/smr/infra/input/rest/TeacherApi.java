package com.sms.smr.infra.input.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.model.academic.Teacher;
import com.sms.smr.domain.ports.in.BaseUseCase;

@RestController
@RequestMapping(value = "/api/v1/teacher")
@PreAuthorize("hasAnyAuthority('ROLE_REALM_preceptor')")
public class TeacherApi extends BaseApi<Teacher, Long> {

    public TeacherApi(BaseUseCase<Teacher, Long> teacherUseCase) {
        super(teacherUseCase);
    }

}
