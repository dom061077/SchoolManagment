package com.sms.smr.infra.ouput.persistence.gradelevel;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeLevelJpaRepository extends JpaRepository<GradeLevelEntity, Long>,
        JpaSpecificationExecutor<GradeLevelEntity> {

}
