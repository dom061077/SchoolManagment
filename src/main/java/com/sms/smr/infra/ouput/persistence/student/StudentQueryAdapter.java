package com.sms.smr.infra.ouput.persistence.student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.Student;
import com.sms.smr.domain.ports.out.StudentQueryPersistenceOutputPort;
import com.sms.smr.infra.ouput.persistence.BaseSpecificationBuilder;
import com.sms.smr.infra.ouput.persistence.CycleAvoidingMappingContext;
import com.sms.smr.infra.ouput.persistence.EntityMapper;
import com.sms.smr.infra.ouput.persistence.QueryBaseRepository;

@Repository
public class StudentQueryAdapter extends QueryBaseRepository<Student, Long, StudentEntity, StudentJpaRepository> implements StudentQueryPersistenceOutputPort {

    private final StudentJpaRepository studentJpaRepository;
    private final EntityMapper<Student, StudentEntity> mapper;

    public StudentQueryAdapter(StudentJpaRepository repository, EntityMapper<Student, StudentEntity> mapper) {
        super(repository,new BaseSpecificationBuilder<StudentEntity>(), mapper);
        this.studentJpaRepository = repository;
        this.mapper = mapper;
    }

    @Override
    public Page<Student> searchStudents(Integer dni, String lastName, String firstName, int page, int size) {
        return studentJpaRepository.searchStudents(dni, lastName, firstName, PageRequest.of(page, size))
                .map(entity -> mapper.toDomain(entity, new CycleAvoidingMappingContext()));
    }
}
