package com.sms.smr.infra.ouput.persistence.academic;

import com.sms.smr.infra.ouput.persistence.academic.teacher.TeacherEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

import com.sms.smr.infra.ouput.persistence.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "examenes_escolares", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "id_materia", "id_periodo_lectivo", "id_tipo_examen" })
})
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SchoolExamEntity extends BaseEntity {
    private String name;
    private String description;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "id_tipo_examen")
    @NotNull
    private TipoExamenEntity tipoExamen;
    @ManyToOne
    @JoinColumn(name = "id_periodo_lectivo")
    @NotNull
    private AcademicPeriodEntity academicPeriod;
    @ManyToOne
    @JoinColumn(name = "id_materia")
    @NotNull
    private SubjectEntity subject;
    @ManyToOne
    @JoinColumn(name = "id_docente")
    private TeacherEntity teacher;

    @OneToMany(mappedBy = "schoolExam", cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true)
    private java.util.List<SchoolExamDetailEntity> details;

}
