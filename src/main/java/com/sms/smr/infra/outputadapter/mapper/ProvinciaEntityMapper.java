package com.sms.smr.infra.outputadapter.mapper;

import org.mapstruct.Mapper;

import com.sms.smr.domain.Provincia;
import com.sms.smr.infra.outputadapter.db.ProvinciaEntity;

@Mapper(componentModel="spring")
public interface ProvinciaEntityMapper extends EntityMapper<Provincia, ProvinciaEntity> {

}
