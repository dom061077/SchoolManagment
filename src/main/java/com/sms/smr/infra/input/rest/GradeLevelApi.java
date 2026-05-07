package com.sms.smr.infra.input.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.model.GradeLevel;
import com.sms.smr.domain.ports.in.BaseUseCase;

@RestController
@RequestMapping("/api/v1/grade-level")
public class GradeLevelApi extends BaseApi<GradeLevel, Long> {

    public GradeLevelApi(BaseUseCase<GradeLevel, Long> service) {
        super(service);
    }
}
