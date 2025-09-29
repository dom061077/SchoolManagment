package com.sms.smr.infra.outputadapter.db;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.AllArgsConstructor;

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

    @OneToMany(mappedBy = "provincia")
    private List<DepartamentoEntity> departamentos;
    
}
