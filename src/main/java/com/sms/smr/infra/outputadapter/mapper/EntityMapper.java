package com.sms.smr.infra.outputadapter.mapper;

import org.mapstruct.Context;
import org.mapstruct.MappingTarget;

public interface EntityMapper<D, E> {
    D toDomain(E entity, @Context CycleAvoidingMappingContext context);
    E toEntity(D domain , @Context CycleAvoidingMappingContext context);
    void updateEntityFromDomain(D d, @MappingTarget E e, @Context CycleAvoidingMappingContext context);
    //List<D> getDomainList(List<E> entities, @Context CycleAvoidingMappingContext context);
}
