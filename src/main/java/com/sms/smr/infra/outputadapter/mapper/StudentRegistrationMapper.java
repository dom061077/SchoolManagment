package com.sms.smr.infra.outputadapter.mapper;

import java.util.List;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import com.sms.smr.domain.Student;
import com.sms.smr.domain.StudentRegistration;
import com.sms.smr.infra.outputadapter.db.academic.StudentRegistrationEntity;

@Mapper(componentModel = "spring")
public interface StudentRegistrationMapper extends EntityMapper<StudentRegistration, StudentRegistrationEntity> {
    @Override
    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "studentFirstName", source = "student.firstName")
    @Mapping(target = "studentLastName", source = "student.lastName")
    @Mapping(target = "studentDni", source = "student.dni")
    @Mapping(target = "academicYearId", source = "academicYear.id")
    @Mapping(target = "gradeLevelId", source = "gradeLevel.id")
    @Mapping(target = "shiftId", source = "shift.id")
    @Mapping(target = "sectionId", source = "section.id")
    StudentRegistration toDomain(StudentRegistrationEntity entity, @Context CycleAvoidingMappingContext context);

    @Override
    @Mapping(target = "student", ignore = true)
    @Mapping(target = "academicYear", ignore = true)
    @Mapping(target = "gradeLevel", ignore = true)
    @Mapping(target = "shift", ignore = true)
    @Mapping(target = "section", ignore = true)
    StudentRegistrationEntity toEntity(StudentRegistration domain, @Context CycleAvoidingMappingContext context);

    @Override
    @Mapping(target = "student", ignore = true)
    @Mapping(target = "academicYear", ignore = true)
    @Mapping(target = "gradeLevel", ignore = true)
    @Mapping(target = "shift", ignore = true)
    @Mapping(target = "section", ignore = true)    
    void updateEntityFromDomain(StudentRegistration d, @MappingTarget StudentRegistrationEntity e, @Context CycleAvoidingMappingContext context);

    @Override
    default List<StudentRegistration> getDomainList(List<StudentRegistrationEntity> entities, @Context CycleAvoidingMappingContext context) {
        if (entities == null) return List.of();
        return entities.stream()
                .map(entity -> toDomain(entity, context))
                .toList();
    }
}
