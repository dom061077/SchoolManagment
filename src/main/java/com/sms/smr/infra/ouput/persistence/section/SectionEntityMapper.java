package com.sms.smr.infra.ouput.persistence.section;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.sms.smr.domain.model.Section;
import com.sms.smr.infra.ouput.persistence.CycleAvoidingMappingContext;
import com.sms.smr.infra.ouput.persistence.EntityMapper;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SectionEntityMapper extends EntityMapper<Section, SectionEntity> {

    @Override
    @Mapping(target = "gradeLevels", ignore = true)
    SectionEntity toEntity(Section domain, @Context CycleAvoidingMappingContext context);

    @Override
    Section toDomain(SectionEntity entity, @Context CycleAvoidingMappingContext context);

    @Override
    @Mapping(target = "gradeLevels", ignore = true)
    void updateEntityFromDomain(Section domain, @MappingTarget SectionEntity entity,
            @Context CycleAvoidingMappingContext context);

}
