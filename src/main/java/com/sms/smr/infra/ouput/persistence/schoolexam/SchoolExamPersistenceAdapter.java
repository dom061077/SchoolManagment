package com.sms.smr.infra.ouput.persistence.schoolexam;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.academic.SchoolExam;
import com.sms.smr.infra.ouput.persistence.BaseRepository;
import com.sms.smr.infra.ouput.persistence.academic.SchoolExamEntity;

@Repository
public class SchoolExamPersistenceAdapter extends BaseRepository<SchoolExam, Long, SchoolExamEntity, SchoolExamJpaRepository> {
    public SchoolExamPersistenceAdapter(SchoolExamJpaRepository repository, SchoolExamMapper mapper) {
        super(repository, mapper, SchoolExamEntity.class);
    }
}
