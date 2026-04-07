package com.sms.smr.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.sms.smr.domain.model.Departamento;
import com.sms.smr.domain.ports.in.BaseQueryUseCase;
import com.sms.smr.domain.ports.in.BaseUseCase;
import com.sms.smr.domain.ports.out.CrudPersistenceOutputPort;
import com.sms.smr.domain.ports.out.QueryPersistenceOutputPort;
import com.sms.smr.infra.input.QueryResult;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartamentoService implements BaseQueryUseCase<Departamento, Long> {
    private final QueryPersistenceOutputPort<Departamento, Long> queryPersistenceOutputPort;


    @Override
    public Page<Departamento> getAll(int offset, int limit,String queryFilters, String sortings,
            String loperator) {
        return queryPersistenceOutputPort.getAll(offset, limit, queryFilters, sortings, loperator); 
    }

}
