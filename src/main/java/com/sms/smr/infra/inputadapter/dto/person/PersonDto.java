package com.sms.smr.infra.inputadapter.dto.person;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDto {

    private Long id;

    private String apellido;

    private String nombre;

    private java.sql.Date fechaNacimiento;
    
}
