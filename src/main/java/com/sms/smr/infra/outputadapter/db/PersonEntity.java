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
    int dni;
    String padre;
    String madre;
    java.sql.Date fechaNacimiento;
    java.sql.Date fechaBautismo;
    java.sql.Date fechaConfirmacion;
    java.sql.Date fechaMatrimonio;

    int nroLibro;
    int nroFolio;
    String apellidoPadrinoBaut;
    String nombrePadrinoBaut;
    String apellidoPadrinoConf;
    String nombrePadrinoConf;
    String apellidoMatrimonio;
    String nombreMatrimonio;
    String otrasNotas;

    
    
    
}
