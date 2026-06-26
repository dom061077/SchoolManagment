package com.sms.smr.domain.service;

import java.util.Arrays;
import java.util.List;

import com.sms.smr.domain.model.EstudioEnum;
import com.sms.smr.domain.ports.in.EnumValuesUseCase;


public class EnumValuesService implements EnumValuesUseCase {

    @Override
    public List<EstudioEnum> getEstudioEnumValues() {
        return Arrays.asList(EstudioEnum.values());
    }



}
