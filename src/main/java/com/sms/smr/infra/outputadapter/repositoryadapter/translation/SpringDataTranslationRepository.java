package com.sms.smr.infra.outputadapter.repositoryadapter.translation;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sms.smr.infra.outputadapter.db.TranslationEntity;

public interface SpringDataTranslationRepository extends JpaRepository<TranslationEntity, Long> {

}
