package com.sms.smr.infra.outputadapter.mapper;

import java.util.List;

public interface GenericMapper <E,D>{
    D toDomain(E entity);
    E toEntity(D domain);

    List<D> getDomainList(List<E> entities);
}
