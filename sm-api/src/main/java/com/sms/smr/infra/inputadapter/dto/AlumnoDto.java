package com.sms.smr.infra.inputadapter.dto;


import com.sms.smr.domain.EstudioEnum;
import com.sms.smr.domain.Localidad;
import com.sms.smr.domain.ParentescoTutor;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;





@Getter
@Setter
public class AlumnoDto{


    private Long id;

    @NotBlank
    private String apellido;


    @NotBlank
    private String nombre;


    @NotNull
    private java.sql.Date fechaNacimiento;


    @NotNull
    private int dni;


    @NotBlank
    private String cuil;


    @NotBlank
    private String direccion;


    private boolean planSocial=false;


    private boolean trabaja=false;


    private String apellidoTutor;


    private String nombreTutor;

    private EstudioEnum estudioPrimarioTutor;


    private EstudioEnum estudioSecundarioTutor;


    private EstudioEnum estudioTerUnivTutor;


    private int dniTutor;


    private String cuilTutor;
    
 
    private String telefono1;
    

    private String telefono2;
    

    private boolean fotoDni=false;
    

    private boolean constanciaCuil=false;


    private boolean constancia6grado=false;
    

    private boolean actaNacimiento=false;
    

    private boolean constanciaRegular=false;
    

    private boolean foto4x4=false;
    

    private boolean fotoCarnetVac=false;
    

    private boolean fichaMedica=false;
    

    private boolean aptitudFisica=false;
    

    private boolean grupoSanguineo=false;
    

    private boolean fichaInscripcion=false;
    

    private boolean libreta6grado=false;
    

    private boolean fotocopiaLibroMatriz=false;
    

    private boolean fotocopiaDniTutor=false;
    

    private boolean constanciaCuilTutor=false;    

    ParentescoTutor parentescoTutor;
    Localidad localidad;
}