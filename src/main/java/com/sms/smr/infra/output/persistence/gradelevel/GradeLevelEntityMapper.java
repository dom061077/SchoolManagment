package com.sms.smr.infra.output.persistence.gradelevel;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.sms.smr.domain.model.GradeLevel;
import com.sms.smr.infra.output.persistence.CycleAvoidingMappingContext;
import com.sms.smr.infra.output.persistence.EntityMapper;

@Mapper(componentModel = "spring")
public interface GradeLevelEntityMapper extends EntityMapper<GradeLevel, GradeLevelEntity> {

    @Override
    @Mapping(target = "sections", ignore = true)
    @Mapping(target = "shifts", ignore = true)
    GradeLevelEntity toEntity(GradeLevel domain, @Context CycleAvoidingMappingContext context);

    @Override
    GradeLevel toDomain(GradeLevelEntity entity, @Context CycleAvoidingMappingContext context);

    @Override
    @Mapping(target = "sections", ignore = true)
    @Mapping(target = "shifts", ignore = true)
    void updateEntityFromDomain(GradeLevel d, @MappingTarget GradeLevelEntity e,
            @Context CycleAvoidingMappingContext context);
}
