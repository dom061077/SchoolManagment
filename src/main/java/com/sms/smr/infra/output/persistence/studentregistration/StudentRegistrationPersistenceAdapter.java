package com.sms.smr.infra.output.persistence.studentregistration;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.StudentRegistration;
import com.sms.smr.infra.output.persistence.BaseRepository;
import com.sms.smr.infra.output.persistence.academic.StudentRegistrationEntity;

@Repository
public class StudentRegistrationPersistenceAdapter extends BaseRepository<StudentRegistration, Long, StudentRegistrationEntity, StudentRegistrationJpaRepository>{
    public StudentRegistrationPersistenceAdapter(StudentRegistrationJpaRepository repository, StudentRegistrationMapper mapper) {
        super(repository, mapper, StudentRegistrationEntity.class);
    }

}
