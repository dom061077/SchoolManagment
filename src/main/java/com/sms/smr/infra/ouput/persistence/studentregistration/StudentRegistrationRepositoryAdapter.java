package com.sms.smr.infra.ouput.persistence.studentregistration;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.StudentRegistration;
import com.sms.smr.infra.ouput.persistence.BaseRepository;
import com.sms.smr.infra.ouput.persistence.db.academic.StudentRegistrationEntity;
import com.sms.smr.infra.outputadapter.mapper.StudentRegistrationMapper;

@Repository
public class StudentRegistrationRepositoryAdapter extends BaseRepository<StudentRegistration, Long, StudentRegistrationEntity, StudentRegistrationJpaRepository>{
    public StudentRegistrationRepositoryAdapter(StudentRegistrationJpaRepository repository, StudentRegistrationMapper mapper) {
        super(repository, mapper, StudentRegistrationEntity.class);
    }

}
