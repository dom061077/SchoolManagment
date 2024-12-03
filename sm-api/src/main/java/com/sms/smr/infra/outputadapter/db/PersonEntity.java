package com.sms.smr.infra.outputadapter.db;

import java.time.LocalDateTime;

import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="person")
//@Audited
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
