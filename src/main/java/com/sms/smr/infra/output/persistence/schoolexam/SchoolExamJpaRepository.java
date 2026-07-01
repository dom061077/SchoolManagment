package com.sms.smr.infra.output.persistence.schoolexam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sms.smr.infra.output.persistence.academic.SchoolExamEntity;

@Repository
public interface SchoolExamJpaRepository extends JpaRepository<SchoolExamEntity, Long>, JpaSpecificationExecutor<SchoolExamEntity> {

}
