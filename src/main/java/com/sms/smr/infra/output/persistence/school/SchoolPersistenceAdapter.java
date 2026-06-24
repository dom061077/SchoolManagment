package com.sms.smr.infra.ouput.persistence.school;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.School;
import com.sms.smr.infra.ouput.persistence.BaseRepository;

@Repository
public class SchoolPersistenceAdapter extends BaseRepository<School, Long, SchoolEntity, SchoolJpaRepository> {

    public SchoolPersistenceAdapter(SchoolJpaRepository repository, SchoolEntityMapper mapper) {
        super(repository, mapper, SchoolEntity.class);
    }
}

