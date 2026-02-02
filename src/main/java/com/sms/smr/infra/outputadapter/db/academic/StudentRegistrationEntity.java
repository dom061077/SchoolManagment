package com.sms.smr.infra.outputadapter.db.academic;

import com.sms.smr.infra.outputadapter.db.BaseEntity;
import com.sms.smr.infra.outputadapter.db.StudentEntity;
import com.sms.smr.infra.outputadapter.db.school.GradeLevelEntity;
import com.sms.smr.infra.outputadapter.db.school.SectionEntity;
import com.sms.smr.infra.outputadapter.db.school.ShiftEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name="inscripcion_alumno")
public class StudentRegistrationEntity extends BaseEntity {
    @ManyToOne
    private StudentEntity student;
    @ManyToOne
    private AcademicPeriodEntity academicPeriod;
    @ManyToOne
    private GradeLevelEntity gradeLevel;
    @ManyToOne
    private ShiftEntity shift;
    @ManyToOne
    private SectionEntity section;
}
