package com.sms.smr.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sms.smr.domain.Departamento;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.inputport.DepartamentoInputPort;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;
import com.sms.smr.infra.outputport.CrudOutputPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartamentoUseCase implements DepartamentoInputPort{
    private final CrudOutputPort<Departamento, Long> crudOutputPort;

    @Override
    public QueryResult<Departamento> getAll(int offset, int limit, List<QueryDto> queryFilters,
            List<QueryDto> sortings) {
        return crudOutputPort.getAll(offset, limit, queryFilters, sortings);
        
    }

}
