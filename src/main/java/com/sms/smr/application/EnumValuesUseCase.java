package com.sms.smr.application;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sms.smr.domain.EstudioEnum;
import com.sms.smr.infra.inputport.EnumValuesInputPort;

@Service
public class EnumValuesUseCase implements EnumValuesInputPort {

    @Override
    public List<EstudioEnum> getEstudioEnumValues() {
        return Arrays.asList(EstudioEnum.values());
    }



}
