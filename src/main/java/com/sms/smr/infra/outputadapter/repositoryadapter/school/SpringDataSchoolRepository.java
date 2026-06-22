package com.sms.smr.infra.outputadapter.repositoryadapter.school;

import org.springframework.stereotype.Component;

import com.sms.smr.domain.model.School;
import com.sms.smr.infra.ouput.persistence.BaseRepository;
import com.sms.smr.infra.ouput.persistence.EntityMapper;
import com.sms.smr.infra.ouput.persistence.school.SchoolEntity;
import com.sms.smr.infra.ouput.persistence.school.SchoolJpaRepository;

@Component
public class SpringDataSchoolRepository extends BaseRepository<School, Long, SchoolEntity, SchoolJpaRepository> {

    public SpringDataSchoolRepository(SchoolJpaRepository repository, EntityMapper<School, SchoolEntity> mapper) {
        super(repository, mapper, SchoolEntity.class);
    }
}
