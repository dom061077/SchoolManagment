package com.sms.smr.infra.ouput.persistence.section;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SectionJpaRepository
                extends JpaRepository<SectionEntity, Long>, JpaSpecificationExecutor<SectionEntity> {

}
