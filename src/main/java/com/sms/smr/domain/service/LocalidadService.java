package com.sms.smr.domain.service;

import java.util.Optional;

import com.sms.smr.domain.model.PageResponse;
import org.springframework.stereotype.Service;

import com.sms.smr.domain.model.Localidad;
import com.sms.smr.domain.ports.in.BaseUseCase;
import com.sms.smr.domain.ports.out.QueryPersistenceOutputPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocalidadService implements BaseUseCase<Localidad, Long> {
    private final QueryPersistenceOutputPort<Localidad, Long> queryOutputPort;

    @Override
    public Localidad create(Localidad entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Optional<Localidad> getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public Localidad update(Long id, Localidad domain) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public PageResponse<Localidad> getAll(int offset, int limit, String queryFilters, String sortings,
            String loperator) {
        return queryOutputPort.getAll(offset, limit, queryFilters, sortings, loperator);
    }

}

