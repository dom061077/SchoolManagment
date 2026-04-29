package com.sms.smr.infra.outputadapter.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.sms.smr.domain.model.Shift;
import com.sms.smr.infra.ouput.persistence.CycleAvoidingMappingContext;
import com.sms.smr.infra.ouput.persistence.EntityMapper;
import com.sms.smr.infra.ouput.persistence.school.ShiftEntity;

@Mapper(componentModel = "spring")
public interface ShiftEntityMapper extends EntityMapper<Shift, ShiftEntity> {

    @Override
    Shift toDomain(ShiftEntity entity, @Context CycleAvoidingMappingContext context);

    @Override
    ShiftEntity toEntity(Shift domain, @Context CycleAvoidingMappingContext context);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "gradeLevels", ignore = true)
    void updateEntityFromDomain(Shift source, @MappingTarget ShiftEntity target, @Context CycleAvoidingMappingContext context);
}
