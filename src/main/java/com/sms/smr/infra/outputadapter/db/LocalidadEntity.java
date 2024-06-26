package com.sms.smr.infra.outputadapter.db;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="localidad")
public class LocalidadEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @ManyToOne
    private DepartamentoEntity departamento;
}
