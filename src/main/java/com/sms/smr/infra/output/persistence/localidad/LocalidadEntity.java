package com.sms.smr.infra.ouput.persistence.localidad;

import com.sms.smr.infra.ouput.persistence.BaseEntity;
import com.sms.smr.infra.ouput.persistence.departamento.DepartamentoEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@Entity
@NoArgsConstructor
@SuperBuilder
@Table(name="localidad")
public class LocalidadEntity extends BaseEntity {



    private String nombre;

    @ManyToOne
    private DepartamentoEntity departamento;
}
