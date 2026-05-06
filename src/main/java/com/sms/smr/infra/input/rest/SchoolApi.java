package com.sms.smr.infra.input.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.model.School;
import com.sms.smr.domain.ports.in.BaseUseCase;

@RestController
@RequestMapping(value = "/api/v1/school")
@PreAuthorize("hasAnyAuthority('ROLE_REALM_preceptor')")
public class SchoolApi extends BaseApi<School, Long> {

    public SchoolApi(BaseUseCase<School, Long> schoolUseCase) {
        super(schoolUseCase);
    }
}
