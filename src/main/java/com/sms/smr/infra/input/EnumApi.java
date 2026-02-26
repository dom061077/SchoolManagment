package com.sms.smr.infra.input;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.model.EstudioEnum;
import com.sms.smr.infra.inputadapter.dto.enumeration.EstudioEnumDto;
import com.sms.smr.infra.inputport.EnumValuesInputPort;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryResult;

@RestController
@RequestMapping(value="/api/v1/enum")
public class EnumApi {
    private final EnumValuesInputPort enumValuesInputPort;
    public  EnumApi(EnumValuesInputPort enumValuesInputPort){
        this.enumValuesInputPort=enumValuesInputPort;
    }

    
    @GetMapping("/list")
    public QueryResult<EstudioEnumDto> getEstudioEnumValues(){
        List<EstudioEnumDto> enumValues=enumValuesInputPort.getEstudioEnumValues()
            .stream()
            .map((EstudioEnum e)->{
                return EstudioEnumDto.builder()
                    .id(e.name( ))
                    .description(e.toString())
                    .build();
            }).toList();
        QueryResult<EstudioEnumDto> qr=new QueryResult<>();
        qr.setData(enumValues);
        qr.setTotal(enumValues.size());
        return qr;
    }   
    
}
