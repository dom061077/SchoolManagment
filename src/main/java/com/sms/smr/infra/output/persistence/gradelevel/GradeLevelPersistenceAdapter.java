package com.sms.smr.infra.output.persistence.gradelevel;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.GradeLevel;
import com.sms.smr.infra.output.persistence.BaseRepository;

@Repository
public class GradeLevelPersistenceAdapter
        extends BaseRepository<GradeLevel, Long, GradeLevelEntity, GradeLevelJpaRepository> {

    public GradeLevelPersistenceAdapter(GradeLevelJpaRepository repository, GradeLevelEntityMapper mapper) {
        super(repository, mapper, GradeLevelEntity.class);
    }

}
