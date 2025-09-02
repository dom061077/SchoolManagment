package com.sms.smr.infra.outputadapter.db;

import java.beans.Transient;
import java.time.LocalDate;
import java.time.Period;

import com.sms.smr.domain.EstudioEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
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

    @ManyToOne(fetch = FetchType.LAZY)
    private ParentescoTutorEntity parentescoTutorEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    private LocalidadEntity localidadEntity;


    @Override
    @NotNull(message = "Birth date is required")
    @Past(message = "Birth date must be in the past")    
    public LocalDate getBirthDate(){
        return super.getBirthDate();
    }

    @Transient
    public int getAge(){
        return getBirthDate() != null ? Period.between(getBirthDate(), LocalDate.now()).getYears():0;
    }
 
}
