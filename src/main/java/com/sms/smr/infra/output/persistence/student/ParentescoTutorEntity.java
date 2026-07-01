package com.sms.smr.infra.output.persistence.student;

import com.sms.smr.infra.output.persistence.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name="parentesco_tutor")
public class ParentescoTutorEntity extends BaseEntity {



    private String descripcion;
}
