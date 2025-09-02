package com.sms.smr.infra.outputadapter.mapper;

import java.util.List;

public interface EntityMapper <D,E>{
    D toDomain(E entity);
    E toEntity(D domain);

    List<D> getDomainList(List<E> entities);
}
