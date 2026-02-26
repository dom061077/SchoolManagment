package com.sms.smr.infra.ouput.persistence.translation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataTranslationRepository extends JpaRepository<TranslationEntity, Long> {

}
