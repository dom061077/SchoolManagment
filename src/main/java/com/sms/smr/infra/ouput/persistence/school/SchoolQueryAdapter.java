package com.sms.smr.infra.ouput.persistence.school;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.School;
import com.sms.smr.infra.ouput.persistence.BaseSpecificationBuilder;
import com.sms.smr.infra.ouput.persistence.EntityMapper;
import com.sms.smr.infra.ouput.persistence.QueryBaseRepository;

@Repository
public class SchoolQueryAdapter extends QueryBaseRepository<School, Long, SchoolEntity, SchoolJpaRepository> {

    public SchoolQueryAdapter(SchoolJpaRepository repository, EntityMapper<School, SchoolEntity> mapper) {
        super(repository, new BaseSpecificationBuilder<SchoolEntity>(), mapper);
    }
}
