package com.sms.smr.infra.outputadapter.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import com.sms.smr.domain.Student;
import com.sms.smr.domain.StudentRegistration;
import com.sms.smr.infra.outputadapter.db.StudentEntity;
import com.sms.smr.infra.outputadapter.db.academic.AcademicYearEntity;
import com.sms.smr.infra.outputadapter.db.academic.StudentRegistrationEntity;
import com.sms.smr.infra.outputadapter.db.school.GradeLevelEntity;
import com.sms.smr.infra.outputadapter.db.school.SectionEntity;
import com.sms.smr.infra.outputadapter.db.school.ShiftEntity;
import com.sms.smr.infra.outputadapter.mapper.CycleAvoidingMappingContext;

@Mapper(
    componentModel = "spring",
    uses = StudentRegistrationReferenceMapper.class
)
public interface StudentRegistrationMapper
        extends EntityMapper<StudentRegistration, StudentRegistrationEntity> {

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