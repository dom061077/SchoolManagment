package com.sms.smr.infra.ouput.persistence.departamento;

import java.util.List;

import com.sms.smr.infra.ouput.persistence.provincia.ProvinciaEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "departamento")
public class DepartamentoEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @ManyToOne
    private ProvinciaEntity provincia;

    //@OneToMany(mappedBy = "departamento")
    //private List<LocalidadEntity> localidades;
    
}
