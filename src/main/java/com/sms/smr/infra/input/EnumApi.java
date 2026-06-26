package com.sms.smr.infra.input;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.model.EstudioEnum;
import com.sms.smr.infra.inputadapter.dto.enumeration.EstudioEnumDto;
import com.sms.smr.domain.ports.in.EnumValuesUseCase;

@RestController
@RequestMapping(value="/api/v1/enum")
public class EnumApi {
    private final EnumValuesUseCase enumValuesUseCase;
    public  EnumApi(EnumValuesUseCase enumValuesUseCase){
        this.enumValuesUseCase=enumValuesUseCase;
    }

    
    @GetMapping("/list")
    public QueryResult<EstudioEnumDto> getEstudioEnumValues(){
        List<EstudioEnumDto> enumValues=enumValuesUseCase.getEstudioEnumValues()
            .stream()
            .map((EstudioEnum e)->{
                return EstudioEnumDto.builder()
                    .id(e.name( ))
                    .description(e.toString())
                    .build();
            }).toList();
        QueryResult<EstudioEnumDto> qr=new QueryResult<>();
        qr.setContent(enumValues);
        qr.setTotalElements(enumValues.size());
        return qr;
    }   
    
}
