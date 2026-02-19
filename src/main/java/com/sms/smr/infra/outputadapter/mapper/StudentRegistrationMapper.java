package com.sms.smr.infra.outputadapter.mapper;

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


 /*List<StudentRegistration> getDomainList(
        List<StudentRegistrationEntity> entities,
        @Context CycleAvoidingMappingContext context);*/

    @AfterMapping
    default void setRelations(StudentRegistration domain, @MappingTarget StudentRegistrationEntity entity, @Context CycleAvoidingMappingContext context) {
        if (domain == null || entity == null) return;

        // Map student
        if (domain.getStudentId() != null) {
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setId(domain.getStudentId());
            entity.setStudent(studentEntity);
        }

        // Map academic year
        if (domain.getAcademicYearId() != null) {
            AcademicYearEntity academicYearEntity = new AcademicYearEntity();
            academicYearEntity.setId(domain.getAcademicYearId());
            entity.setAcademicYear(academicYearEntity);
        }

        // Map grade level
        if (domain.getGradeLevelId() != null) {
            GradeLevelEntity gradeLevelEntity = new GradeLevelEntity();
            gradeLevelEntity.setId(domain.getGradeLevelId());
            entity.setGradeLevel(gradeLevelEntity);
        }

        // Map shift
        if (domain.getShiftId() != null) {
            ShiftEntity shiftEntity = new ShiftEntity();
            shiftEntity.setId(domain.getShiftId());
            entity.setShift(shiftEntity);
        }

        // Map section
        if (domain.getSectionId() != null) {
            SectionEntity sectionEntity = new SectionEntity();
            sectionEntity.setId(domain.getSectionId());
            entity.setSection(sectionEntity);
        }
    }
    
}
