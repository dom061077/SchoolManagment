package com.sms.smr.infra.output.persistence.studentregistration;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.StudentRegistration;
import com.sms.smr.infra.output.persistence.BaseSpecificationBuilder;
import com.sms.smr.infra.output.persistence.QueryBaseRepository;
import com.sms.smr.infra.output.persistence.academic.StudentRegistrationEntity;

@Repository
public class StudentRegistrationrQueryAdapter extends QueryBaseRepository<StudentRegistration, Long, StudentRegistrationEntity, StudentRegistrationJpaRepository> {
    public StudentRegistrationrQueryAdapter(StudentRegistrationJpaRepository repository, StudentRegistrationMapper mapper) {
        super(repository, new BaseSpecificationBuilder<StudentRegistrationEntity>(), mapper);
    }   

}
