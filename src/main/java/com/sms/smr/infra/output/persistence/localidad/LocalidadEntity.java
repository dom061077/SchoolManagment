package com.sms.smr.infra.output.persistence.localidad;

import com.sms.smr.infra.output.persistence.BaseEntity;
import com.sms.smr.infra.output.persistence.departamento.DepartamentoEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "localidad")
public class LocalidadEntity extends BaseEntity {

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private DepartamentoEntity departamento;
}
