package com.sms.smr.infra.input.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.model.academic.SchoolExam;
import com.sms.smr.domain.ports.in.BaseUseCase;

@RestController
@RequestMapping("/api/v1/school-exams")
@PreAuthorize("hasAnyAuthority('ROLE_REALM_preceptor')")
public class SchoolExamApi extends BaseApi<SchoolExam, Long> {

    public SchoolExamApi(BaseUseCase<SchoolExam, Long> baseUseCase) {
        super(baseUseCase);
    }
}
