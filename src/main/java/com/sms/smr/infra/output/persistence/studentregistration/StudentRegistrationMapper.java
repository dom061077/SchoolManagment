package com.sms.smr.infra.output.persistence.studentregistration;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import com.sms.smr.domain.model.Student;
import com.sms.smr.domain.model.StudentRegistration;
import com.sms.smr.infra.output.persistence.CycleAvoidingMappingContext;
import com.sms.smr.infra.output.persistence.EntityMapper;
import com.sms.smr.infra.output.persistence.academic.StudentRegistrationEntity;

@Mapper(componentModel = "spring", uses = StudentRegistrationReferenceMapper.class)
public interface StudentRegistrationMapper
                extends EntityMapper<StudentRegistration, StudentRegistrationEntity> {

        @Override
        @Mapping(target = "studentId", source = "student.id")
        @Mapping(target = "studentFirstName", source = "student.firstName")
        @Mapping(target = "studentLastName", source = "student.lastName")
        @Mapping(target = "studentDni", source = "student.dni")
        @Mapping(target = "academicYearId", source = "academicYear.id")
        @Mapping(target = "academicYearYear", source = "academicYear.year")
        @Mapping(target = "gradeLevelId", source = "gradeLevel.id")
        @Mapping(target = "gradeLevelGradeNumber", source = "gradeLevel.gradeNumber")
        @Mapping(target = "shiftId", source = "shift.id")
        @Mapping(target = "shiftName", source = "shift.name")
        @Mapping(target = "sectionId", source = "section.id")
        @Mapping(target = "sectionName", source = "section.name")
        StudentRegistration toDomain(StudentRegistrationEntity entity, @Context CycleAvoidingMappingContext context);

        @Override
        @Mapping(target = "student", source = "studentId")
        @Mapping(target = "academicYear", source = "academicYearId")
        @Mapping(target = "gradeLevel", source = "gradeLevelId")
        @Mapping(target = "shift", source = "shiftId")
        @Mapping(target = "section", source = "sectionId")
        StudentRegistrationEntity toEntity(
                        StudentRegistration domain,
                        @Context CycleAvoidingMappingContext context);

        @Override
        @Mapping(target = "id", ignore = true)
        @Mapping(target = "student", source = "studentId")
        @Mapping(target = "academicYear", source = "academicYearId")
        @Mapping(target = "gradeLevel", source = "gradeLevelId")
        @Mapping(target = "shift", source = "shiftId")
        @Mapping(target = "section", source = "sectionId")
        void updateEntityFromDomain(
                        StudentRegistration source,
                        @MappingTarget StudentRegistrationEntity target,
                        @Context CycleAvoidingMappingContext context);

}