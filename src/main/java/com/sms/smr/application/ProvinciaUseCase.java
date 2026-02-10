package com.sms.smr.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sms.smr.domain.Provincia;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.inputport.ProvinciaInputPort;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;
import com.sms.smr.infra.outputport.CrudOutputPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProvinciaUseCase implements ProvinciaInputPort{
    private final CrudOutputPort<Provincia, Long> crudOutputPort;

    @Override
    public QueryResult<Provincia> getAll(int offset, int limit, List<QueryDto> qfilters, List<QueryDto> sorts) {
        
        return crudOutputPort.getAll(offset, limit, qfilters, sorts);   
    }

}
