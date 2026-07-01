package com.sms.smr.infra.output.persistence.student;

import java.util.List;
import com.sms.smr.domain.model.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.Student;
import com.sms.smr.domain.ports.out.StudentQueryPersistenceOutputPort;
import com.sms.smr.infra.output.persistence.BaseSpecificationBuilder;
import com.sms.smr.infra.output.persistence.CycleAvoidingMappingContext;
import com.sms.smr.infra.output.persistence.EntityMapper;
import com.sms.smr.infra.output.persistence.QueryBaseRepository;

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
    public PageResponse<Student> searchStudents(Integer dni, String lastName, String firstName, int page, int size) {
        Page<StudentEntity> resultPage = studentJpaRepository.searchStudents(dni, lastName, firstName, PageRequest.of(page, size));
        List<Student> content = resultPage.getContent().stream()
                .map(entity -> mapper.toDomain(entity, new CycleAvoidingMappingContext()))
                .toList();
        return PageResponse.<Student>builder()
                .content(content)
                .totalElements(resultPage.getTotalElements())
                .build();
    }
}
