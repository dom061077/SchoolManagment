package com.sms.smr.infra.ouput.persistence.translation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TranslationJpaRepository extends JpaRepository<TranslationEntity, Long >, JpaSpecificationExecutor<TranslationEntity> {

}
