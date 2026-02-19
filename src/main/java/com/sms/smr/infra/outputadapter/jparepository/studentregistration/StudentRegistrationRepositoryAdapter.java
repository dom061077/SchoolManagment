package com.sms.smr.infra.outputadapter.jparepository.studentregistration;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.StudentRegistration;
import com.sms.smr.infra.outputadapter.db.academic.StudentRegistrationEntity;
import com.sms.smr.infra.outputadapter.jpa.BaseRepository;
import com.sms.smr.infra.outputadapter.jpa.repository.StudentRegistrationJpaRepository;
import com.sms.smr.infra.outputadapter.mapper.StudentRegistrationMapper;
import com.sms.smr.infra.outputadapter.jpa.repository.query.StudentRegistrationrQueryJpaRepository;

@Repository
public class StudentRegistrationRepositoryAdapter extends BaseRepository<StudentRegistration, Long, StudentRegistrationEntity, StudentRegistrationJpaRepository, StudentRegistrationrQueryJpaRepository>{
    public StudentRegistrationRepositoryAdapter(StudentRegistrationJpaRepository repository, StudentRegistrationMapper mapper, StudentRegistrationrQueryJpaRepository queryRepository) {
        super(repository, mapper, queryRepository, StudentRegistrationEntity.class);
    }

}
