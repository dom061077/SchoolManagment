package com.sms.smr.infra.output.persistence.section;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SectionJpaRepository
                extends JpaRepository<SectionEntity, Long>, JpaSpecificationExecutor<SectionEntity> {

}
