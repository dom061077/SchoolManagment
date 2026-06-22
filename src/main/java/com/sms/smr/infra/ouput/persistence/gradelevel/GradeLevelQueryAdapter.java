package com.sms.smr.infra.ouput.persistence.gradelevel;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.GradeLevel;
import com.sms.smr.infra.ouput.persistence.BaseSpecificationBuilder;
import com.sms.smr.infra.ouput.persistence.EntityMapper;
import com.sms.smr.infra.ouput.persistence.QueryBaseRepository;

@Repository
public class GradeLevelQueryAdapter
        extends QueryBaseRepository<GradeLevel, Long, GradeLevelEntity, GradeLevelJpaRepository> {

    public GradeLevelQueryAdapter(GradeLevelJpaRepository repository,
            EntityMapper<GradeLevel, GradeLevelEntity> mapper) {
        super(repository, new BaseSpecificationBuilder<GradeLevelEntity>(), mapper);
    }
}
