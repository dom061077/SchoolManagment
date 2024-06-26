package com.sms.smr.infra.outputadapter.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="parentesco_tutor")
public class ParentescoTutorEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String descripcion;
}
