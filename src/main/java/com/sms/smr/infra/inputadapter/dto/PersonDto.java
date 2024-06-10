package com.sms.smr.infra.inputadapter.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDto {

    private Long id;
    @NotNull
    @NotBlank
    private String apellido;
    @NotNull
    @NotBlank
    private String nombre;
    @NotNull
    @NotBlank    
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
    
}
