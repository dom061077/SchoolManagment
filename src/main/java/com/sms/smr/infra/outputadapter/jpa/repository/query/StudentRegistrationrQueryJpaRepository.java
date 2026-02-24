package com.sms.smr.infra.outputadapter.jpa.repository.query;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.StudentRegistration;
import com.sms.smr.infra.outputadapter.db.academic.StudentRegistrationEntity;
import com.sms.smr.infra.outputadapter.jpa.repository.StudentRegistrationJpaRepository;
import com.sms.smr.infra.outputadapter.mapper.StudentRegistrationMapper;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.BaseSpecificationBuilder;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryRepositoryBase;

@Repository
public class StudentRegistrationrQueryJpaRepository extends QueryRepositoryBase<StudentRegistration, Long, StudentRegistrationEntity, StudentRegistrationJpaRepository> {
    public StudentRegistrationrQueryJpaRepository(StudentRegistrationJpaRepository repository, StudentRegistrationMapper mapper) {
        super(repository, new BaseSpecificationBuilder<StudentRegistrationEntity>(), mapper);
    }   

}
