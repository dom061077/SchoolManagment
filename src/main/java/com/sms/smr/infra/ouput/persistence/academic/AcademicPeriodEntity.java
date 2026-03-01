package com.sms.smr.infra.ouput.persistence.academic;

import com.sms.smr.infra.ouput.persistence.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
@Entity
@Table(name="periodo_academico")
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AcademicPeriodEntity extends BaseEntity {
    @Column(name="cantidad_dias_escolares")
    private int numberOfSchoolDays;
    
}
