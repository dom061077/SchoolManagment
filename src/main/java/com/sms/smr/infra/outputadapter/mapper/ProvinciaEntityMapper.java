package com.sms.smr.infra.outputadapter.mapper;

import org.mapstruct.Mapper;

import com.sms.smr.domain.Provincia;
import com.sms.smr.infra.outputadapter.db.ProvinciaEntity;

@Mapper(componentModel="spring", uses = {DepartamentoEntityMapper.class})
public interface ProvinciaEntityMapper extends EntityMapper<Provincia, ProvinciaEntity> {

}
