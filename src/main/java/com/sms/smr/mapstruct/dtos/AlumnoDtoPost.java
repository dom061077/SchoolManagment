package com.sms.smr.mapstruct.dtos;

import com.sms.smr.domain.alumno.Alumno.EstudioEnum;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull; 


@Getter
@Setter
public class AlumnoDtoPost{

    @JsonProperty("id")
    private Long id;
    
    @JsonProperty("apellido")
    private String apellido;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("fechaNacimiento")
    private java.sql.Date fechaNacimiento;
    @JsonProperty("dni")
    private int dni;
    @JsonProperty("cuil")
    private String cuil;
    @JsonProperty("direccion")
    private String direccion;
    @JsonProperty("planSocial")
    private boolean planSocial=false;
    @JsonProperty("trabaja")
    private boolean trabaja=false;
    @JsonProperty("apellidoTutor")
    private String apellidoTutor;
    @JsonProperty("nombreTutor")
    private String nombreTutor;
    @JsonProperty("estudioPrimarioTutor")
    private EstudioEnum estudioPrimarioTutor;
    @JsonProperty("estudioSecundarioTutor")
    private EstudioEnum estudioSecundarioTutor;
    @JsonProperty("estudioTerUnivTutor")
    private EstudioEnum estudioTerUnivTutor;
    @JsonProperty("dniTutor")
    private int dniTutor;
    @JsonProperty("cuilTutor")
    private String cuilTutor;
    
    @JsonProperty("telefono1")
    private String telefono1;
    
    @JsonProperty("telefono2")
    private String telefono2;
    
    @JsonProperty("fotoDni")
    private boolean fotoDni=false;
    
    @JsonProperty("constanciaCuil")
    private boolean constanciaCuil=false;
    @JsonProperty("constancia6grado")
    private boolean constancia6grado=false;
    @JsonProperty("actaNacimiento")
    private boolean actaNacimiento=false;
    
    @JsonProperty("constanciaRegular")
    private boolean constanciaRegular=false;
    
    @JsonProperty("foto4x4")
    private boolean foto4x4=false;
    
    @JsonProperty("fotoCarnetVac")
    private boolean fotoCarnetVac=false;
    
    @JsonProperty("fichaMedica")
    private boolean fichaMedica=false;
    
    @JsonProperty("aptitudFisica")
    private boolean aptitudFisica=false;
    
    @JsonProperty("grupoSanguineo")
    private boolean grupoSanguineo=false;
    
    @JsonProperty("fichaInscripcion")
    private boolean fichaInscripcion=false;
    
    @JsonProperty("libreta6grado")
    private boolean libreta6grado=false;
    
    @JsonProperty("fotocopiaLibroMatriz")
    private boolean fotocopiaLibroMatriz=false;
    
    @JsonProperty("fotocopiaDniTutor")
    private boolean fotocopiaDniTutor=false;
    
    @JsonProperty("constanciaCuilTutor")
    private boolean constanciaCuilTutor=false;    
}