package com.sms.smr.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Localidad {
    private Long id;
    private String nombre;
    private Departamento departamento;
}
