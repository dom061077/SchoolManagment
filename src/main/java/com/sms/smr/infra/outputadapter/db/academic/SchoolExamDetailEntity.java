package com.sms.smr.infra.outputadapter.db.academic;

import java.math.BigDecimal;

import com.sms.smr.infra.outputadapter.db.BaseEntity;

import jakarta.persistence.Column;
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
@Table(name="detalle_examenes_escolares")
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SchoolExamDetailEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="id_examen_escolar")
    private SchoolExamEntity schoolExam;
    @ManyToOne
    @JoinColumn(name="id_periodo_lectivo")
    private AcademicYearEntity academicPeriod;
    @Column(name="calificacion")
    private BigDecimal score;
    @ManyToOne
    @JoinColumn(name="id_inscripcion_alumno")
    private StudentRegistrationEntity studentRegistration;

}
