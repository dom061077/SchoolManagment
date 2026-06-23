package com.sms.smr.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Person extends BaseDomain {
    
    private String apellido;
    private String nombre;
    private int dni;
    private String padre;
    private String madre;
    private java.sql.Date fechaNacimiento;
    private java.sql.Date fechaBautismo;
    private java.sql.Date fechaConfirmacion;
    private java.sql.Date fechaMatrimonio;

    private int nroLibro;
    private int nroFolio;
    private String apellidoPadrinoBaut;
    private String nombrePadrinoBaut;
    private String apellidoPadrinoConf;
    private String nombrePadrinoConf;
    private String apellidoMatrimonio;
    private String nombreMatrimonio;
    private String otrasNotas;

    String apellidoMadrinaBaut;
    String nombreMadrinaBaut;
    String apellidoMadrinaConf;
    String nombreMadrinaConf;    
}
