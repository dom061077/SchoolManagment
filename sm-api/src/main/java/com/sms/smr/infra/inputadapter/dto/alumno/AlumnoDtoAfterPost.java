package com.sms.smr.infra.inputadapter.dto.alumno;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlumnoDtoAfterPost {

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
