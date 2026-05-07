package com.sms.smr.infra.ouput.persistence.academic.academicyear;

import org.springframework.stereotype.Component;

import com.sms.smr.domain.model.academic.AcademicYear;
import com.sms.smr.infra.ouput.persistence.BaseSpecificationBuilder;
import com.sms.smr.infra.ouput.persistence.QueryBaseRepository;

@Component
public class AcademicYearQueryAdapter
        extends QueryBaseRepository<AcademicYear, Long, AcademicYearEntity, AcademicYearJpaRepository> {

    public AcademicYearQueryAdapter(AcademicYearJpaRepository repository, AcademicYearEntityMapper mapper) {
        super(repository, new BaseSpecificationBuilder<AcademicYearEntity>(), mapper);
    }

}
