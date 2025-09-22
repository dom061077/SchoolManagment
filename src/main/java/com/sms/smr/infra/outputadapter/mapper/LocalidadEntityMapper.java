package com.sms.smr.infra.outputadapter.mapper;

import org.mapstruct.Mapper;

import com.sms.smr.domain.Localidad;
import com.sms.smr.infra.outputadapter.db.LocalidadEntity;

@Mapper(componentModel="spring",uses = {DepartamentoEntityMapper.class})
public interface LocalidadEntityMapper extends EntityMapper<Localidad, LocalidadEntity>{

}
