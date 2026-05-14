package com.sms.smr.infra.ouput.persistence.academic;

import java.time.LocalDate;

import com.sms.smr.infra.ouput.persistence.BaseEntity;
import com.sms.smr.infra.ouput.persistence.academic.academicyear.AcademicYearEntity;

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
@Table(name = "periodo_academico")
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AcademicPeriodEntity extends BaseEntity {
    @Column(name = "cantidad_dias_escolares")
    private int numberOfSchoolDays;
    @Column(name = "fecha_inicio")
    private LocalDate startDate;
    @Column(name = "fecha_fin")
    private LocalDate endDate;
    @Column(name = "descripcion")
    private String description;

    @ManyToOne
    @JoinColumn(name = "periodo_lectivo_id")
    private AcademicYearEntity academicYear;

}
