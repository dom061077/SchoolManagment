package com.sms.smr.infra.outputadapter.db;

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
@Builder
@Entity
@Table(name="parentesco_tutor")
public class ParentescoTutorEntity extends BaseEntity {



    private String descripcion;
}
