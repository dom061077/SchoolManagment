package com.sms.smr.infra.ouput.persistence.gradelevel;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.sms.smr.domain.model.GradeLevel;
import com.sms.smr.infra.ouput.persistence.BaseRepository;

@Component
public class GradeLevelPersistenceAdapter
        extends BaseRepository<GradeLevel, Long, GradeLevelEntity, GradeLevelJpaRepository> {

    public GradeLevelPersistenceAdapter(GradeLevelJpaRepository repository, GradeLevelEntityMapper mapper) {
        super(repository, mapper, GradeLevelEntity.class);
    }

}
