package com.sms.smr.infra.ouput.persistence.academic.academicyear;

import org.mapstruct.Context;
import org.mapstruct.Mapper;

import com.sms.smr.domain.model.academic.AcademicYear;
import com.sms.smr.infra.ouput.persistence.CycleAvoidingMappingContext;
import com.sms.smr.infra.ouput.persistence.EntityMapper;

@Mapper(componentModel = "spring")
public interface AcademicYearEntityMapper extends EntityMapper<AcademicYear, AcademicYearEntity> {

    @Override
    AcademicYear toDomain(AcademicYearEntity entity, @Context CycleAvoidingMappingContext context);

    @Override
    AcademicYearEntity toEntity(AcademicYear domain, @Context CycleAvoidingMappingContext context);

}
