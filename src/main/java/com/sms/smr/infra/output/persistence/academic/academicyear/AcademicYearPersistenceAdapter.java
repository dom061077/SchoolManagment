package com.sms.smr.infra.output.persistence.academic.academicyear;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sms.smr.domain.model.academic.AcademicYear;
import com.sms.smr.infra.output.persistence.BaseRepository;

@Component
public class AcademicYearPersistenceAdapter
        extends BaseRepository<AcademicYear, Long, AcademicYearEntity, AcademicYearJpaRepository> {

    public AcademicYearPersistenceAdapter(AcademicYearJpaRepository repository, AcademicYearEntityMapper mapper) {
        super(repository, mapper, AcademicYearEntity.class);
    }

}
