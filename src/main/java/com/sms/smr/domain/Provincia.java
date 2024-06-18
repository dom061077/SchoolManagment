package com.sms.smr.domain;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Provincia {

    private Long id;
    private String nombre;
    private List<Departamento> departamentos;
    
}
