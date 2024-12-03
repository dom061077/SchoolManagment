package com.sms.smr.domain;

import com.sms.smr.infra.outputadapter.db.LocalidadEntity;
import com.sms.smr.infra.outputadapter.db.ParentescoTutorEntity;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter

public class Alumno {

    
    private Long id;
    private String apellido;
    @NotNull
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

    
    private ParentescoTutor parentescoTutor;

    
    private Localidad localidad;


     
    /*String apellido
    String nombre
    String apellidoNombre
    java.sql.Date fechaNacimiento

    int dni
    String cuil
    String direccion
    boolean planSocial=false
    boolean trabaja=false
    
    String apellidoTutor
    String nombreTutor
    EstudioEnum estudioPrimarioTutor
    EstudioEnum estudioSecundarioTutor
    EstudioEnum estudioTerUnivTutor
    
    int dniTutor
    String cuilTutor
    String telefono1
    String telefono2
    boolean fotoDni=false
    boolean constanciaCuil=false
    boolean constancia6grado=false
    boolean actaNacimiento=false
    boolean constanciaRegular=false
    boolean foto4x4=false
    boolean fotoCarnetVac=false
    boolean fichaMedica=false
    boolean aptitudFisica=false
    boolean grupoSanguineo=false
    boolean fichaInscripcion=false
    boolean libreta6grado=false
    boolean fotocopiaLibroMatriz=false
    boolean fotocopiaDniTutor=false
    boolean constanciaCuilTutor=false
    
    Localidad localidad
    ParentescoTutor parentescoTutor
    */    
}
