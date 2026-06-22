package com.sms.smr.infra.input.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.model.academic.AcademicYear;
import com.sms.smr.domain.ports.in.BaseUseCase;

@RestController
@RequestMapping(value = "/api/v1/academic-year")
public class AcademicYearApi extends BaseApi<AcademicYear, Long> {

    public AcademicYearApi(BaseUseCase<AcademicYear, Long> academicYearUseCase) {
        super(academicYearUseCase);
    }

}
