package com.sms.smr.infra.ouput.persistence.localidad;

import org.mapstruct.Context;
import org.mapstruct.Mapper;

import com.sms.smr.domain.model.Departamento;
import com.sms.smr.domain.model.Localidad;
import com.sms.smr.infra.ouput.persistence.CycleAvoidingMappingContext;
import com.sms.smr.infra.ouput.persistence.EntityMapper;
import com.sms.smr.infra.ouput.persistence.departamento.DepartamentoEntity;
import com.sms.smr.infra.ouput.persistence.departamento.DepartamentoEntityMapper;

@Mapper(componentModel="spring",uses = {DepartamentoEntityMapper.class})
public interface LocalidadEntityMapper extends EntityMapper<Localidad, LocalidadEntity>{
    @Override
    Localidad toDomain(LocalidadEntity entity, @Context CycleAvoidingMappingContext context);

    @Override
    LocalidadEntity toEntity(Localidad domain, @Context CycleAvoidingMappingContext context);

}
