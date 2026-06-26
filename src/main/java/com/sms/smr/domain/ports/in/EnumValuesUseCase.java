package com.sms.smr.domain.ports.in;

import java.util.List;

import com.sms.smr.domain.model.EstudioEnum;

public interface EnumValuesUseCase {
    List<EstudioEnum> getEstudioEnumValues();

}
