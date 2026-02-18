package com.sms.smr.infra.outputadapter.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import com.sms.smr.domain.StudentRegistration;
import com.sms.smr.infra.outputadapter.db.academic.StudentRegistrationEntity;

@Component
public class StudentRegistrationMapper implements BaseEntityMapper<StudentRegistration, StudentRegistrationEntity> {

    @Override
    public StudentRegistration toDomain(StudentRegistrationEntity entity) {
        if (entity == null) return null;
        return StudentRegistration.builder()
                .id(entity.getId())
                .studentId((entity.getStudent() != null ? entity.getStudent().getId() : null))
                .studentDni(entity.getStudent() != null ? entity.getStudent().getDni() : 0)
                .academicYearId(entity.getAcademicYear() != null ? entity.getAcademicYear().getId() : null)
                .academicYearYear(entity.getAcademicYear() != null ? entity.getAcademicYear().getYear() : 0)
                .gradeLevelId(entity.getGradeLevel() != null ? entity.getGradeLevel().getId() : null)
                .gradeLevelGradeNumber(entity.getGradeLevel() != null ? entity.getGradeLevel().getGradeNumber() : 0)
                .shiftId(entity.getShift() != null ? entity.getShift().getId() : null)
                .shiftName(entity.getShift() != null ? entity.getShift().getName() : null)
                .sectionId(entity.getSection() != null ? entity.getSection().getId() : null)
                .sectionName(entity.getSection() != null ? entity.getSection().getName() : null)
                .build();
     }

    @Override
    public StudentRegistrationEntity toEntity(StudentRegistration domain) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }

}
