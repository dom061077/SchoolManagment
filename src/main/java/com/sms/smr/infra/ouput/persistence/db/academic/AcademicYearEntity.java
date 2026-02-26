package com.sms.smr.infra.ouput.persistence.db.academic;

import org.hibernate.validator.constraints.EAN;

import com.sms.smr.infra.ouput.persistence.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@Table(name="periodo_lectivo")
@AllArgsConstructor
@NoArgsConstructor
public class AcademicYearEntity extends BaseEntity {
    
    @NotNull
    @Column(name="anio", unique=true)
    private int year;
    @Builder.Default
    private boolean isActive=false;

}
