package com.sms.smr.infra.outputadapter.db;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="provincia")
public class ProvinciaEntity {

    @Id
    @GeneratedValue
    Long id;
    String nombre;

    @OneToMany(mappedBy = "provincia")
    private List<LocalidadEntity> localidades;
    
}
