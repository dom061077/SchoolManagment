package com.sms.smr.infra.outputadapter.jpa.repository.query;

import org.springframework.stereotype.Repository;

import com.sms.smr.infra.outputadapter.db.StudentEntity;
import com.sms.smr.infra.outputadapter.jpa.repository.StudentJpaRepository;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.BaseSpecificationBuilder;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryRepositoryBase;

@Repository
public class StudentQueryJpaRepository extends QueryRepositoryBase<StudentEntity, Long, StudentJpaRepository> {
    public StudentQueryJpaRepository(StudentJpaRepository repository) {
        super(repository,new BaseSpecificationBuilder<StudentEntity>());
    }

}
