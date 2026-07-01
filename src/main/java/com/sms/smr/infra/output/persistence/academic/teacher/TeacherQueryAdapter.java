package com.sms.smr.infra.output.persistence.academic.teacher;

import org.springframework.stereotype.Component;

import com.sms.smr.domain.model.academic.Teacher;
import com.sms.smr.infra.output.persistence.BaseSpecificationBuilder;
import com.sms.smr.infra.output.persistence.QueryBaseRepository;

@Component
public class TeacherQueryAdapter
        extends QueryBaseRepository<Teacher, Long, TeacherEntity, TeacherJpaRepository> {

    public TeacherQueryAdapter(TeacherJpaRepository repository, TeacherEntityMapper mapper) {
        super(repository, new BaseSpecificationBuilder<TeacherEntity>(), mapper);
    }

}
