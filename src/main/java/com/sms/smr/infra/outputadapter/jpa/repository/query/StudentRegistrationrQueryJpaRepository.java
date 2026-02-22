package com.sms.smr.infra.outputadapter.jpa.repository.query;

import org.springframework.stereotype.Repository;

import com.sms.smr.infra.outputadapter.db.academic.StudentRegistrationEntity;
import com.sms.smr.infra.outputadapter.jpa.repository.StudentRegistrationJpaRepository;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.BaseSpecificationBuilder;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryRepositoryBase;

@Repository
public class StudentRegistrationrQueryJpaRepository extends QueryRepositoryBase<StudentRegistrationEntity, Long, StudentRegistrationJpaRepository> {
    public StudentRegistrationrQueryJpaRepository(StudentRegistrationJpaRepository repository) {
        super(repository, new BaseSpecificationBuilder<StudentRegistrationEntity>());
    }   

}
