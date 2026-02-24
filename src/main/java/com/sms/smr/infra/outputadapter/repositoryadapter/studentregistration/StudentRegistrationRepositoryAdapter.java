package com.sms.smr.infra.outputadapter.repositoryadapter.studentregistration;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.StudentRegistration;
import com.sms.smr.infra.outputadapter.db.academic.StudentRegistrationEntity;
import com.sms.smr.infra.outputadapter.jpa.BaseRepository;
import com.sms.smr.infra.outputadapter.jpa.repository.StudentRegistrationJpaRepository;
import com.sms.smr.infra.outputadapter.mapper.StudentRegistrationMapper;

@Repository
public class StudentRegistrationRepositoryAdapter extends BaseRepository<StudentRegistration, Long, StudentRegistrationEntity, StudentRegistrationJpaRepository>{
    public StudentRegistrationRepositoryAdapter(StudentRegistrationJpaRepository repository, StudentRegistrationMapper mapper) {
        super(repository, mapper, StudentRegistrationEntity.class);
    }

}
