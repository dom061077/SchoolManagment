package com.sms.smr.infra.outputadapter.jpa.repository.query;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.Student;
import com.sms.smr.infra.outputadapter.db.StudentEntity;
import com.sms.smr.infra.outputadapter.jpa.repository.StudentJpaRepository;
import com.sms.smr.infra.outputadapter.mapper.EntityMapper;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.BaseSpecificationBuilder;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryRepositoryBase;

@Repository
public class StudentQueryJpaRepository extends QueryRepositoryBase<Student, Long, StudentEntity, StudentJpaRepository> {
    //(R repository, BaseSpecificationBuilder<E> specificationBuilder, EntityMapper<T, E> mapper) {

    public StudentQueryJpaRepository(StudentJpaRepository repository, EntityMapper<Student, StudentEntity> mapper) {
        super(repository,new BaseSpecificationBuilder<StudentEntity>(), mapper);
    }

}
