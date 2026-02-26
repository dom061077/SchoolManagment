package com.sms.smr.infra.ouput.persistence.departamento;

import org.mapstruct.Context;
import org.mapstruct.Mapper;

import com.sms.smr.domain.model.Departamento;
import com.sms.smr.infra.ouput.persistence.CycleAvoidingMappingContext;
import com.sms.smr.infra.ouput.persistence.EntityMapper;


@Mapper(componentModel = "spring"/*, uses = {ProvinciaEntityMapper.class, LocalidadEntityMapper.class}*/)
public interface DepartamentoEntityMapper extends EntityMapper<Departamento, DepartamentoEntity> {

    @Override
    Departamento toDomain(DepartamentoEntity entity, @Context CycleAvoidingMappingContext context);

    @Override
    DepartamentoEntity toEntity(Departamento domain, @Context CycleAvoidingMappingContext context);
}