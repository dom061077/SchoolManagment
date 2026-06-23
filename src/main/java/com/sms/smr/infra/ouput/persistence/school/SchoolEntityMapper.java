package com.sms.smr.infra.ouput.persistence.school;

import com.sms.smr.domain.model.School;
import com.sms.smr.infra.ouput.persistence.CycleAvoidingMappingContext;
import com.sms.smr.infra.ouput.persistence.EntityMapper;
import org.mapstruct.Builder;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SchoolEntityMapper extends EntityMapper<School, SchoolEntity> {

    @Override
    School toDomain(SchoolEntity entity, @Context CycleAvoidingMappingContext context);

    @Override
    SchoolEntity toEntity(School domain, @Context CycleAvoidingMappingContext context);
}
