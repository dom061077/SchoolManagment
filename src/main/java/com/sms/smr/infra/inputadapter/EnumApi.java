package com.sms.smr.infra.inputadapter;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.EstudioEnum;
import com.sms.smr.infra.inputadapter.dto.enumeration.EstudioEnumDto;
import com.sms.smr.infra.inputport.EnumValuesInputPort;

@RestController
@RequestMapping(value="/api/v1/enum")
public class EnumApi {
    private final EnumValuesInputPort enumValuesInputPort;
    public  EnumApi(EnumValuesInputPort enumValuesInputPort){
        this.enumValuesInputPort=enumValuesInputPort;
    }

    @GetMapping("/estudio")
    public List<EstudioEnumDto> getEstudioEnumValues(){
        List<EstudioEnumDto> enumValues=enumValuesInputPort.getEstudioEnumValues()
            .stream()
            .map((EstudioEnum e)->{
                return EstudioEnumDto.builder()
                    .code(e.name( ))
                    .description(e.toString())
                    .build();
            }).toList();
        return enumValues;
    }   
    
}
