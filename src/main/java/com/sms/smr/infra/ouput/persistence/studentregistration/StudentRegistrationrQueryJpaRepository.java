package com.sms.smr.infra.ouput.persistence.studentregistration;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.StudentRegistration;
import com.sms.smr.infra.ouput.persistence.BaseSpecificationBuilder;
import com.sms.smr.infra.ouput.persistence.QueryRepositoryBase;
import com.sms.smr.infra.ouput.persistence.academic.StudentRegistrationEntity;

@Repository
public class StudentRegistrationrQueryJpaRepository extends QueryRepositoryBase<StudentRegistration, Long, StudentRegistrationEntity, StudentRegistrationJpaRepository> {
    public StudentRegistrationrQueryJpaRepository(StudentRegistrationJpaRepository repository, StudentRegistrationMapper mapper) {
        super(repository, new BaseSpecificationBuilder<StudentRegistrationEntity>(), mapper);
    }   

}
