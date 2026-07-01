package com.sms.smr.infra.output.persistence.studentregistration;

import org.mapstruct.Mapper;

import com.sms.smr.infra.output.persistence.academic.academicyear.AcademicYearEntity;
import com.sms.smr.infra.output.persistence.gradelevel.GradeLevelEntity;
import com.sms.smr.infra.output.persistence.school.ShiftEntity;
import com.sms.smr.infra.output.persistence.section.SectionEntity;
import com.sms.smr.infra.output.persistence.student.StudentEntity;

@Mapper(componentModel = "spring")
public interface StudentRegistrationReferenceMapper {

    default StudentEntity mapStudent(Long id) {
        if (id == null)
            return null;
        StudentEntity e = new StudentEntity();
        e.setId(id);
        return e;
    }

    default AcademicYearEntity mapAcademicYear(Long id) {
        if (id == null)
            return null;
        AcademicYearEntity e = new AcademicYearEntity();
        e.setId(id);
        return e;
    }

    default GradeLevelEntity mapGradeLevel(Long id) {
        if (id == null)
            return null;
        GradeLevelEntity e = new GradeLevelEntity();
        e.setId(id);
        return e;
    }

    default ShiftEntity mapShift(Long id) {
        if (id == null)
            return null;
        ShiftEntity e = new ShiftEntity();
        e.setId(id);
        return e;
    }

    default SectionEntity mapSection(Long id) {
        if (id == null)
            return null;
        SectionEntity e = new SectionEntity();
        e.setId(id);
        return e;
    }
}