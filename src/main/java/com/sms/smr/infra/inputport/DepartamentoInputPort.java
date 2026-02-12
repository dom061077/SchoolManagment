package com.sms.smr.infra.inputport;

import java.util.List;

import com.sms.smr.domain.Departamento;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;

public interface DepartamentoInputPort {

    QueryResult<Departamento> getAll(int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortings);

}

