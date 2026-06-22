package com.sms.smr.infra.outputadapter.mapper;

import java.util.List;

/**
 * Deprecated: Use EntityMapper instead. This interface is kept for backward compatibility and will be removed in future versions.
 * @param <D>
 * @param <E>
 */

public interface BaseEntityMapper<D, E> {

    D toDomain(E entity);

    E toEntity(D domain);

    default List<D> toDomainList(List<E> entities) {
        if (entities == null) return List.of();
        return entities.stream()
                .map(this::toDomain)
                .toList();
    }

    default List<E> toEntityList(List<D> domains) {
        if (domains == null) return List.of();
        return domains.stream()
                .map(this::toEntity)
                .toList();
    }
}