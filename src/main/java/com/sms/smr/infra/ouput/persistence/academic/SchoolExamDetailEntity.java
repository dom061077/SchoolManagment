package com.sms.smr.infra.ouput.persistence.academic;

import java.math.BigDecimal;

import com.sms.smr.infra.ouput.persistence.BaseEntity;
import com.sms.smr.infra.ouput.persistence.academic.academicyear.AcademicYearEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "detalle_examenes_escolares", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "id_inscripcion_alumno", "id_examen_escolar" })
})
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SchoolExamDetailEntity extends BaseEntity {

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_examen_escolar")
    private SchoolExamEntity schoolExam;

    @Column(name = "calificacion")
    private BigDecimal score;
    @ManyToOne
    @JoinColumn(name = "id_inscripcion_alumno")
    private StudentRegistrationEntity studentRegistration;

}
