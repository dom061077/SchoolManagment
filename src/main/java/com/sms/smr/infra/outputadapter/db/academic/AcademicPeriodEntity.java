package com.sms.smr.infra.outputadapter.db.academic;

import org.hibernate.validator.constraints.EAN;

import com.sms.smr.infra.outputadapter.db.BaseEntity;

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
public class AcademicPeriodEntity extends BaseEntity {
    
    @NotNull
    private int year;
    @Builder.Default
    private boolean isActive=false;

}
