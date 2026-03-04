package com.sms.smr.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.sms.smr.domain.model.Departamento;
import com.sms.smr.domain.ports.in.BaseUseCase;
import com.sms.smr.domain.ports.out.CrudPersistenceOutputPort;
import com.sms.smr.infra.input.QueryResult;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartamentoService implements BaseUseCase<Departamento, Long> {
    private final CrudPersistenceOutputPort<Departamento, Long> crudOutputPort;

    @Override
    public Departamento create(Departamento entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Optional<Departamento> getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public Departamento update(Long id, Departamento domain) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<Departamento> getAll(int offset, int limit,String queryFilters, String sortings,
            String loperator) {
        // TODO
        throw new UnsupportedOperationException();
    }

}
