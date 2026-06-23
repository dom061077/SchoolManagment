package com.sms.smr.infra.ouput.persistence.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PersonJpaRepository extends JpaRepository<PersonEntity, Long>, JpaSpecificationExecutor<PersonEntity> {
}
