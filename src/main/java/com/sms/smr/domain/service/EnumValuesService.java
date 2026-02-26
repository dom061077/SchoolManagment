package com.sms.smr.domain.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sms.smr.domain.model.EstudioEnum;
import com.sms.smr.infra.inputport.EnumValuesInputPort;

@Service
public class EnumValuesService implements EnumValuesInputPort {

    @Override
    public List<EstudioEnum> getEstudioEnumValues() {
        return Arrays.asList(EstudioEnum.values());
    }



}
