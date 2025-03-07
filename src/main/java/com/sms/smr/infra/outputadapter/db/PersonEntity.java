package com.sms.smr.infra.outputadapter.db;

import org.hibernate.envers.Audited;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="person")
@Audited
public class PersonEntity extends BaseEntity {



    String apellido;
    

    String nombre;
    int dni;
    String padre;
    String madre;
    java.sql.Date fechaNacimiento;
    java.sql.Date fechaBautismo;
    java.sql.Date fechaConfirmacion;
    java.sql.Date fechaMatrimonio;

    int nroLibro;
    int nroFolio;
    String apellidoPadrinoBaut;
    String apellidoMadrinaBaut;
    String nombrePadrinoBaut;
    String nombreMadrinaBaut;
    String apellidoPadrinoConf;
    String apellidoMadrinaConf;
    String nombrePadrinoConf;
    String nombreMadrinaConf;
    String apellidoMatrimonio;
    String nombreMatrimonio;
    String otrasNotas;

   
    
}
