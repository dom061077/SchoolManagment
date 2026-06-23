package com.sms.smr.infra.ouput.persistence.academic.academicyear;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.sms.smr.infra.ouput.persistence.academic.academicyear.AcademicYearEntity;

public interface AcademicYearJpaRepository extends JpaRepository<AcademicYearEntity, Long>,
        JpaSpecificationExecutor<AcademicYearEntity> {

}
