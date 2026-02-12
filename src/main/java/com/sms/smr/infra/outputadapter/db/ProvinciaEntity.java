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
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder   
@Builder
@Table(name="provincia")
public class ProvinciaEntity extends BaseEntity {


    private String nombre;

    //@OneToMany(mappedBy = "provincia", fetch = FetchType.LAZY)
    //private List<DepartamentoEntity> departamentos;
    
}
