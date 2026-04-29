package com.sms.smr.infra.ouput.persistence.school;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftJpaRepository extends JpaRepository<ShiftEntity, Long>, JpaSpecificationExecutor<ShiftEntity> {
}
