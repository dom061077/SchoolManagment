package com.sms.smr.infra.ouput.persistence.academic;

import com.sms.smr.infra.ouput.persistence.BaseEntity;
import com.sms.smr.infra.ouput.persistence.academic.academicyear.AcademicYearEntity;
import com.sms.smr.infra.ouput.persistence.gradelevel.GradeLevelEntity;
import com.sms.smr.infra.ouput.persistence.school.ShiftEntity;
import com.sms.smr.infra.ouput.persistence.section.SectionEntity;
import com.sms.smr.infra.ouput.persistence.student.StudentEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "inscripcion_alumno", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"alumno_id", "periodo_lectivo_id"})
})
public class StudentRegistrationEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "alumno_id")
    @NotNull
    private StudentEntity student;
    @ManyToOne
    @JoinColumn(name = "periodo_lectivo_id")
    @NotNull
    private AcademicYearEntity academicYear;
    @ManyToOne
    @JoinColumn(name = "nivel_grado_id")
    @NotNull
    private GradeLevelEntity gradeLevel;
    @ManyToOne
    @JoinColumn(name = "turno_id")
    @NotNull
    private ShiftEntity shift;
    @ManyToOne
    @JoinColumn(name = "division_id")
    @NotNull
    private SectionEntity section;

    @Transient
    private String studentDniLastNameFirstName;

    public String getStudentDniLastNameFirstName() {
        return student != null ? student.getDni() + " " + student.getLastName() + " " + student.getFirstName() : null;
    }
}
