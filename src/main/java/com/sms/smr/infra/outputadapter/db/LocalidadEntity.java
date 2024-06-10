package com.sms.smr.infra.outputadapter.db;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor

public class LocalidadEntity {

    @Id
    @GeneratedValue
    Long id;

    String nombre;

    @ManyToOne
    ProvinciaEntity provincia;
}
