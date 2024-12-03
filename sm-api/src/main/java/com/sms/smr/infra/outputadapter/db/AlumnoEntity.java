package com.sms.smr.infra.outputadapter.db;

import com.sms.smr.domain.EstudioEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="alumno")
public class AlumnoEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String apellido;
    //@Column(nullable = false)
    @NotEmpty
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

    @ManyToOne
    private ParentescoTutorEntity parentescoTutorEntity;

    @ManyToOne
    private LocalidadEntity localidadEntity;



 
}
