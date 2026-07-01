package com.sms.smr.infra.output.persistence.schoolexam;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.academic.SchoolExam;
import com.sms.smr.infra.output.persistence.BaseSpecificationBuilder;
import com.sms.smr.infra.output.persistence.QueryBaseRepository;
import com.sms.smr.infra.output.persistence.academic.SchoolExamEntity;

@Repository
public class SchoolExamQueryAdapter extends QueryBaseRepository<SchoolExam, Long, SchoolExamEntity, SchoolExamJpaRepository> {
    public SchoolExamQueryAdapter(SchoolExamJpaRepository repository, SchoolExamMapper mapper) {
        super(repository, new BaseSpecificationBuilder<SchoolExamEntity>(), mapper);
    }
}
