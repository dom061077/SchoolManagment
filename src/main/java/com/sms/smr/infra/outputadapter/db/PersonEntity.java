package com.sms.smr.infra.outputadapter.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="person")
public class PersonEntity {

    @Id
    @GeneratedValue
    private Long id;
    String apellido;
    String nombre;

    java.sql.Date fechaNacimiento;
    
}
