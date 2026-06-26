package com.sms.smr.infra.ouput.persistence.academic.teacher;

import org.springframework.stereotype.Component;

import com.sms.smr.domain.model.academic.Teacher;
import com.sms.smr.infra.ouput.persistence.BaseRepository;

@Component
public class TeacherPersistenceAdapter
        extends BaseRepository<Teacher, Long, TeacherEntity, TeacherJpaRepository> {

    public TeacherPersistenceAdapter(TeacherJpaRepository repository, TeacherEntityMapper mapper) {
        super(repository, mapper, TeacherEntity.class);
    }

}
