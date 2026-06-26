package com.sms.smr.domain.service;

import java.util.List;
import java.util.Optional;

import com.sms.smr.domain.model.PageResponse;
import com.sms.smr.domain.model.Departamento;
import com.sms.smr.domain.ports.in.BaseQueryUseCase;
import com.sms.smr.domain.ports.out.QueryPersistenceOutputPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DepartamentoService implements BaseQueryUseCase<Departamento, Long> {
    private final QueryPersistenceOutputPort<Departamento, Long> queryPersistenceOutputPort;


    @Override
    public PageResponse<Departamento> getAll(int offset, int limit,String queryFilters, String sortings,
            String loperator) {
        return queryPersistenceOutputPort.getAll(offset, limit, queryFilters, sortings, loperator);
    }
}
