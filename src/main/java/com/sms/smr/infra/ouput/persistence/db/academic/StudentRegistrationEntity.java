package com.sms.smr.infra.ouput.persistence.db.academic;

import com.sms.smr.infra.ouput.persistence.BaseEntity;
import com.sms.smr.infra.ouput.persistence.db.school.GradeLevelEntity;
import com.sms.smr.infra.ouput.persistence.db.school.SectionEntity;
import com.sms.smr.infra.ouput.persistence.db.school.ShiftEntity;
import com.sms.smr.infra.ouput.persistence.student.StudentEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
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
    @JoinColumn(name="alumno_id")
    private StudentEntity student;
    @ManyToOne
    @JoinColumn(name="periodo_lectivo_id")
    private AcademicYearEntity academicYear;
    @ManyToOne
    @JoinColumn(name="nivel_grado_id")
    private GradeLevelEntity gradeLevel;
    @ManyToOne
    @JoinColumn(name="turno_id")
    private ShiftEntity shift;
    @ManyToOne
    @JoinColumn(name="division_id")
    private SectionEntity section;
}
