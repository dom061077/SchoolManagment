package com.sms.smr.infra.outputadapter.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;

import com.sms.smr.domain.Departamento;
import com.sms.smr.domain.Localidad;
import com.sms.smr.infra.outputadapter.db.DepartamentoEntity;
import com.sms.smr.infra.outputadapter.db.LocalidadEntity;

@Mapper(componentModel="spring",uses = {DepartamentoEntityMapper.class})
public interface LocalidadEntityMapper extends EntityMapper<Localidad, LocalidadEntity>{
    @Override
    Localidad toDomain(LocalidadEntity entity, @Context CycleAvoidingMappingContext context);

    @Override
    LocalidadEntity toEntity(Localidad domain, @Context CycleAvoidingMappingContext context);

}
