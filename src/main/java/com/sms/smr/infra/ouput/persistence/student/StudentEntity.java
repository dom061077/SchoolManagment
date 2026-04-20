package com.sms.smr.infra.ouput.persistence.student;

import java.beans.Transient;
import java.time.LocalDate;
import java.time.Period;

import com.sms.smr.domain.model.EstudioEnum;
import com.sms.smr.infra.ouput.persistence.BasePersonEntity;
import com.sms.smr.infra.ouput.persistence.localidad.LocalidadEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name="alumno")
public class StudentEntity extends BasePersonEntity {

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
    @Enumerated(EnumType.STRING)
    private EstudioEnum estudioPrimarioTutor;
    @Enumerated(EnumType.STRING)
    private EstudioEnum estudioSecundarioTutor;
    @Enumerated(EnumType.STRING)
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

    @ManyToOne(fetch = FetchType.LAZY)
    private ParentescoTutorEntity parentescoTutorEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    private LocalidadEntity localidadEntity;


    @Override
    @Past(message = "Birth date must be in the past")    
    public LocalDate getBirthDate(){
        return super.getBirthDate();
    }

    @Transient
    public int getAge(){
        return getBirthDate() != null ? Period.between(getBirthDate(), LocalDate.now()).getYears():0;
    }
 
}
