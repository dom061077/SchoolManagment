package com.sms.smr.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sms.smr.domain.Localidad;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.inputport.LocalidadInputPort;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;
import com.sms.smr.infra.outputport.CrudOutputPort;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class LocalidadUseCase implements LocalidadInputPort {
    private final CrudOutputPort<Localidad, Long> crudOutputPort;



    @Override
    public QueryResult<Localidad> getAll(int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortings) {
        return crudOutputPort.getAll(offset, limit, queryFilters, sortings);
    }

}
