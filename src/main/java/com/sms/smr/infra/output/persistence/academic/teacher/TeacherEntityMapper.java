package com.sms.smr.infra.ouput.persistence.academic.teacher;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.sms.smr.domain.model.academic.Teacher;
import com.sms.smr.infra.ouput.persistence.CycleAvoidingMappingContext;
import com.sms.smr.infra.ouput.persistence.EntityMapper;

@Mapper(componentModel = "spring")
public interface TeacherEntityMapper extends EntityMapper<Teacher, TeacherEntity> {

    @Override
    Teacher toDomain(TeacherEntity entity, @Context CycleAvoidingMappingContext context);

    @Override
    @Mapping(target = "subjects", ignore = true)
    TeacherEntity toEntity(Teacher domain, @Context CycleAvoidingMappingContext context);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "subjects", ignore = true)
    void updateEntityFromDomain(Teacher domain, @MappingTarget TeacherEntity entity, @Context CycleAvoidingMappingContext context);
}
