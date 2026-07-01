package com.sms.smr.infra.output.persistence.section;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.Section;
import com.sms.smr.infra.output.persistence.BaseSpecificationBuilder;
import com.sms.smr.infra.output.persistence.EntityMapper;
import com.sms.smr.infra.output.persistence.QueryBaseRepository;

import org.springframework.stereotype.Component;

@Repository
public class SectionQueryAdapter extends QueryBaseRepository<Section, Long, SectionEntity, SectionJpaRepository> {

    public SectionQueryAdapter(SectionJpaRepository repository, EntityMapper<Section, SectionEntity> mapper) {
        super(repository, new BaseSpecificationBuilder<SectionEntity>(), mapper);
    }

}
