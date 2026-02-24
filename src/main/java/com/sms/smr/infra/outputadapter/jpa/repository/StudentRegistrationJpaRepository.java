package com.sms.smr.infra.outputadapter.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sms.smr.infra.outputadapter.db.academic.StudentRegistrationEntity;

@Repository
public interface StudentRegistrationJpaRepository extends JpaRepository<StudentRegistrationEntity, Long>, JpaSpecificationExecutor<StudentRegistrationEntity> {

}
