package com.sms.smr.infra.outputadapter.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sms.smr.infra.outputadapter.db.academic.StudentRegistrationEntity;


public interface StudentRegistrationJpaRepository extends JpaRepository<StudentRegistrationEntity, Long>, JpaSpecificationExecutor<StudentRegistrationEntity> {

}
