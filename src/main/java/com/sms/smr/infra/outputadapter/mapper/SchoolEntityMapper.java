package com.sms.smr.infra.outputadapter.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.sms.smr.domain.model.School;
import com.sms.smr.infra.ouput.persistence.CycleAvoidingMappingContext;
import com.sms.smr.infra.ouput.persistence.EntityMapper;
import com.sms.smr.infra.ouput.persistence.school.SchoolEntity;

@Mapper(componentModel = "spring")
public interface SchoolEntityMapper extends EntityMapper<School, SchoolEntity> {

    @Override
    School toDomain(SchoolEntity entity, @Context CycleAvoidingMappingContext context);

    @Override
    SchoolEntity toEntity(School domain, @Context CycleAvoidingMappingContext context);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    void updateEntityFromDomain(School source, @MappingTarget SchoolEntity target, @Context CycleAvoidingMappingContext context);
}
