package com.sms.smr.infra.ouput.persistence.student;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.Student;
import com.sms.smr.infra.ouput.persistence.BaseSpecificationBuilder;
import com.sms.smr.infra.ouput.persistence.EntityMapper;
import com.sms.smr.infra.ouput.persistence.QueryRepositoryBase;

@Repository
public class StudentQueryAdapter extends QueryRepositoryBase<Student, Long, StudentEntity, StudentJpaRepository> {
    //(R repository, BaseSpecificationBuilder<E> specificationBuilder, EntityMapper<T, E> mapper) {

    public StudentQueryAdapter(StudentJpaRepository repository, EntityMapper<Student, StudentEntity> mapper) {
        super(repository,new BaseSpecificationBuilder<StudentEntity>(), mapper);
    }

}
