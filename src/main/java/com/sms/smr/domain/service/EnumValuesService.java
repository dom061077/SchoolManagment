package com.sms.smr.domain.service;

import java.util.Arrays;
import java.util.List;

import com.sms.smr.domain.model.EstudioEnum;
import com.sms.smr.infra.inputport.EnumValuesInputPort;

public class EnumValuesService implements EnumValuesInputPort {

    @Override
    public List<EstudioEnum> getEstudioEnumValues() {
        return Arrays.asList(EstudioEnum.values());
    }



}
