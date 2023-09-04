package com.sms.smr.mapstruct.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlumnoDtoPost {

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

}
