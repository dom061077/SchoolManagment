package com.sms.smr.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter

public class Alumno {

    
    private Long id;
    String apellido;
    @NotNull
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


    public static enum EstudioEnum{
        ESTUDIO_COMPLETO("Completo"),
        ESTUDIO_INCOMPLETO("Incompleto");
        
        
        private String name;
        
        EstudioEnum(String name){
            this.name=name;
        }
        
        @Override
        public String toString(){
            return this.name;
        }
        
    
    }
     
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
