package com.sms.smr.infra.outputadapter.mapper;

import org.mapstruct.Context;
import org.mapstruct.Mapper;

import com.sms.smr.domain.Provincia;
import com.sms.smr.infra.outputadapter.db.ProvinciaEntity;

@Mapper(componentModel = "spring")
public interface ProvinciaEntityMapper extends EntityMapper<Provincia, ProvinciaEntity> {
    
    // Override the methods to include the Context
    @Override
    Provincia toDomain(ProvinciaEntity entity, @Context CycleAvoidingMappingContext context);

    @Override
    ProvinciaEntity toEntity(Provincia domain, @Context CycleAvoidingMappingContext context);
}