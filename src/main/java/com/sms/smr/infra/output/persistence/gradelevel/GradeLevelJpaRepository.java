package com.sms.smr.infra.output.persistence.gradelevel;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeLevelJpaRepository extends JpaRepository<GradeLevelEntity, Long>,
                JpaSpecificationExecutor<GradeLevelEntity> {

}
