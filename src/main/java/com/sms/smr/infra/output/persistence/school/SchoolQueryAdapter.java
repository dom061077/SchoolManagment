package com.sms.smr.infra.ouput.persistence.school;

import java.util.Optional;
import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.School;
import com.sms.smr.domain.ports.out.SchoolQueryPersistenceOutputPort;
import com.sms.smr.infra.ouput.persistence.BaseSpecificationBuilder;
import com.sms.smr.infra.ouput.persistence.CycleAvoidingMappingContext;
import com.sms.smr.infra.ouput.persistence.EntityMapper;
import com.sms.smr.infra.ouput.persistence.QueryBaseRepository;

@Repository
public class SchoolQueryAdapter extends QueryBaseRepository<School, Long, SchoolEntity, SchoolJpaRepository> 
        implements SchoolQueryPersistenceOutputPort {

    private final SchoolJpaRepository schoolJpaRepository;
    private final EntityMapper<School, SchoolEntity> mapper;

    public SchoolQueryAdapter(SchoolJpaRepository repository, EntityMapper<School, SchoolEntity> mapper) {
        super(repository, new BaseSpecificationBuilder<SchoolEntity>(), mapper);
        this.schoolJpaRepository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<School> findByCue(String cue) {
        return schoolJpaRepository.findByCue(cue)
                .map(entity -> mapper.toDomain(entity, new CycleAvoidingMappingContext()));
    }
}

