package com.sms.smr.infra.output.persistence.provincia;

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
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder   
@Table(name="provincia")
public class ProvinciaEntity extends BaseEntity {


    private String nombre;

    //@OneToMany(mappedBy = "provincia", fetch = FetchType.LAZY)
    //private List<DepartamentoEntity> departamentos;
    
}
