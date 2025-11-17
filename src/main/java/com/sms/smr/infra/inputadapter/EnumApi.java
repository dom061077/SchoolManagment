package com.sms.smr.infra.inputadapter;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sms.smr.application.EnumValuesUseCase;
import com.sms.smr.domain.EstudioEnum;
import com.sms.smr.infra.inputport.EnumValuesInputPort;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value="/api/v1/enum")
public class EnumApi {
    private final EnumValuesInputPort enumValuesInputPort;
    public  EnumApi(EnumValuesInputPort enumValuesInputPort){
        this.enumValuesInputPort=enumValuesInputPort;
    }

    @GetMapping("/estudio")
    public List<String> getEstudioEnumValues(){
        List<String> enumValues=enumValuesInputPort.getEstudioEnumValues()
            .stream()
            .map(e->{
                return e.name();
            })
            .toList();
        return enumValues;
    }   
    
}
