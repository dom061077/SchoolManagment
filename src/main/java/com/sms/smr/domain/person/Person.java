package com.sms.smr.domain.person;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class Person {

    private Long id;
    
    String apellido;
    String nombre;
    java.sql.Date fechaNacimiento;
}
