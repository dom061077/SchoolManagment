package com.sms.smr.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class Person {

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
