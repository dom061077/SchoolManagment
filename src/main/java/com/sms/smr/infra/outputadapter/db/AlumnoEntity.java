package com.sms.smr.infra.outputadapter.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@Table(name="alumno")
public class AlumnoEntity {
    @Id
    @GeneratedValue
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
}
