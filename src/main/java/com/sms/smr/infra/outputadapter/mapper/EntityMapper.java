package com.sms.smr.infra.outputadapter.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

public interface EntityMapper <D,E>{
    D toDomain(E entity);
    E toEntity(D domain);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDomain(D domain, @MappingTarget E entity);
    List<D> getDomainList(List<E> entities);
}
