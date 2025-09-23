package com.sms.smr.domain;


import java.time.LocalDate;
import java.time.Period;

import com.sms.smr.infra.outputadapter.db.LocalidadEntity;
import com.sms.smr.infra.outputadapter.db.ParentescoTutorEntity;
import lombok.Builder;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@Builder
public class Student extends BasePersonDomain{
    //private java.sql.Date fechaNacimiento;
    //private int dni;
    private String cuil;
    //private String direccion;
    @Builder.Default
    private boolean planSocial=false;
    @Builder.Default
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
    @Builder.Default
    private boolean fotoDni=false;
    @Builder.Default
    private boolean constanciaCuil=false;
    @Builder.Default
    private boolean constancia6grado=false;
    @Builder.Default
    private boolean actaNacimiento=false;
    @Builder.Default
    private boolean constanciaRegular=false;
    @Builder.Default
    private boolean foto4x4=false;
    @Builder.Default
    private boolean fotoCarnetVac=false;
    @Builder.Default
    private boolean fichaMedica=false;
    @Builder.Default
    private boolean aptitudFisica=false;
    @Builder.Default
    private boolean grupoSanguineo=false;
    @Builder.Default
    private boolean fichaInscripcion=false;
    @Builder.Default
    private boolean libreta6grado=false;
    @Builder.Default
    private boolean fotocopiaLibroMatriz=false;
    @Builder.Default
    private boolean fotocopiaDniTutor=false;
    @Builder.Default
    private boolean constanciaCuilTutor=false;    

    private ParentescoTutor parentescoTutorEntity;

    private Localidad localidadEntity;


    @Override
    @Past(message = "Birth date must be in the past")    
    public LocalDate getBirthDate(){
        return super.getBirthDate();
    }

    public int getAge(){
        return getBirthDate() != null ? Period.between(getBirthDate(), LocalDate.now()).getYears():0;
    }

    
}
