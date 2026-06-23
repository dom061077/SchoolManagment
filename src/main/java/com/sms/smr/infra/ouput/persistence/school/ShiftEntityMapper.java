package com.sms.smr.infra.ouput.persistence.school;

import com.sms.smr.domain.model.Shift;
import com.sms.smr.infra.ouput.persistence.CycleAvoidingMappingContext;
import com.sms.smr.infra.ouput.persistence.EntityMapper;
import org.mapstruct.Builder;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ShiftEntityMapper extends EntityMapper<Shift, ShiftEntity> {

    @Override
    Shift toDomain(ShiftEntity entity, @Context CycleAvoidingMappingContext context);

    @Override
    ShiftEntity toEntity(Shift domain, @Context CycleAvoidingMappingContext context);
} 