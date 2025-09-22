package com.sms.smr.infra.outputadapter.mapper;

import java.util.List;

import org.mapstruct.MappingTarget;

public interface EntityMapper <D,E>{
    D toDomain(E entity);
    E toEntity(D domain);

    void updateEntityFromDomain(D d, @MappingTarget  E e);
    List<D> getDomainList(List<E> entities);
}
