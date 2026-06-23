package com.sms.smr.infra.ouput.persistence.studentregistration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sms.smr.infra.ouput.persistence.academic.StudentRegistrationEntity;

@Repository
public interface StudentRegistrationJpaRepository extends JpaRepository<StudentRegistrationEntity, Long>, JpaSpecificationExecutor<StudentRegistrationEntity> {

}
