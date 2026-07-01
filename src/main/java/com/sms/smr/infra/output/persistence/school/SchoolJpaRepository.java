package com.sms.smr.infra.output.persistence.school;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.Optional;

public interface SchoolJpaRepository extends JpaRepository<SchoolEntity, Long>, JpaSpecificationExecutor<SchoolEntity> {
    Optional<SchoolEntity> findByCue(String cue);

    boolean existsByCue(String cue);
}
