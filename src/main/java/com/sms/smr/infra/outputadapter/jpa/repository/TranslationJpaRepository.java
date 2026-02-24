package com.sms.smr.infra.outputadapter.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sms.smr.infra.outputadapter.db.TranslationEntity;

public interface TranslationJpaRepository extends JpaRepository<TranslationEntity, Long >, JpaSpecificationExecutor<TranslationEntity> {

}
