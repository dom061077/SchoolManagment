package com.sms.smr.infra.ouput.persistence.academic;

import com.sms.smr.infra.ouput.persistence.BaseEntity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="tipo_periodo_academico")
@AllArgsConstructor
@NoArgsConstructor
public class AcademicTypePeriodEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;

}
