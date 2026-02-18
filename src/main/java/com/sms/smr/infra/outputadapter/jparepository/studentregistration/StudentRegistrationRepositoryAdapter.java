package com.sms.smr.infra.outputadapter.jparepository.studentregistration;

import com.sms.smr.domain.StudentRegistration;
import com.sms.smr.infra.outputadapter.db.academic.StudentRegistrationEntity;
import com.sms.smr.infra.outputadapter.jpa.BaseRepository;
import com.sms.smr.infra.outputadapter.jpa.repository.StudentRegistrationJpaRepository;
import com.sms.smr.infra.outputadapter.mapper.StudentRegistrationMapper;

public class StudentRegistrationRepositoryAdapter extends BaseRepository<StudentRegistration, Long, StudentRegistrationEntity, StudentRegistrationJpaRepository, StudentRegistrationQueryJpaRepository>{
    public StudentRegistrationRepositoryAdapter(StudentRegistrationJpaRepository repository, StudentRegistrationMapper mapper, StudentRegistrationQueryJpaRepository queryRepository) {
        super(repository, mapper, queryRepository);
    }

}
