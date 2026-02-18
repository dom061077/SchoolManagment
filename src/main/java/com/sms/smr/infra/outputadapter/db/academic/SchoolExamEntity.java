package com.sms.smr.infra.outputadapter.db.academic;

import com.sms.smr.infra.outputadapter.db.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="examenes_escolares")
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SchoolExamEntity extends BaseEntity{
    private String name;
    private String description;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name="id_tipo_examen")
    private TipoExamenEntity tipoExamen;
    @ManyToOne
    @JoinColumn(name="id_periodo_lectivo")
    private AcademicPeriodEntity academicPeriod;
    @ManyToOne
    @JoinColumn(name="id_materia")
    private SubjectEntity subject;
    @ManyToOne
    @JoinColumn(name="id_docente")
    private TeacherEntity teacher;
    
}
