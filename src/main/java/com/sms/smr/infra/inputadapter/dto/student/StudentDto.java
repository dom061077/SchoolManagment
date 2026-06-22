package com.sms.smr.infra.inputadapter.dto.student;


import com.sms.smr.domain.model.EstudioEnum;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;





@Getter
@Setter
@Builder
public class StudentDto{


    private Long id;

    private String apellido;


    private String nombre;


    private java.sql.Date fechaNacimiento;


    private int dni;


    private String cuil;


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

    Long localidadId;
    Long parentescoTutorId;
}