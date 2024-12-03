package com.sms.smr.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class Person {

    private Long id;
    
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
    private LocalDateTime createDate;
    
    private LocalDateTime lastModified;
    private String createdBy;
    private String lastModifiedBy;           

}
