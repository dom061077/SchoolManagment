package com.sms.smr.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String apellido;
    String nombre;
    java.sql.Date fechaNacimiento;
    int dni;
    String cuil;
    String direccion;
    boolean planSocial=false;
    boolean trabaja=false;
    String apellidoTutor;
    String nombreTutor;
    EstudioEnum estudioPrimarioTutor;
    EstudioEnum estudioSecundarioTutor;
    EstudioEnum estudioTerUnivTutor;
    
    int dniTutor;
    String cuilTutor;
    String telefono1;
    String telefono2;
    boolean fotoDni=false;
    boolean constanciaCuil=false;
    boolean constancia6grado=false;
    boolean actaNacimiento=false;
    boolean constanciaRegular=false;
    boolean foto4x4=false;
    boolean fotoCarnetVac=false;
    boolean fichaMedica=false;
    boolean aptitudFisica=false;
    boolean grupoSanguineo=false;
    boolean fichaInscripcion=false;
    boolean libreta6grado=false;
    boolean fotocopiaLibroMatriz=false;
    boolean fotocopiaDniTutor=false;
    boolean constanciaCuilTutor=false;    

     
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
