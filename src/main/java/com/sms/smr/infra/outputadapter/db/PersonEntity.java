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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name="person")
@Audited
public class PersonEntity {

    @Id
    @GeneratedValue
    private Long id;
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
    String nombrePadrinoBaut;
    String apellidoPadrinoConf;
    String nombrePadrinoConf;
    String apellidoMatrimonio;
    String nombreMatrimonio;
    String otrasNotas;

    @CreatedDate
    @Column(
            nullable = false,
            updatable = false
    )
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModified;


    @CreatedBy
    @Column(
            nullable = false,
            updatable = false
    )
    private Long createdBy;

    @LastModifiedBy
    @Column(insertable = false)
    private Long lastModifiedBy;    
    
    
}
