package com.sms.smr.infra.inputport;


import java.util.List;

import com.sms.smr.domain.Provincia;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;

public interface ProvinciaInputPort {

    QueryResult<Provincia> getAll(int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortings);
}
