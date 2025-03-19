package com.sms.smr.infra.inputport;

import java.util.List;

import com.sms.smr.domain.MenuRole;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;

public interface MenuRolePort extends BaseInputPort<MenuRole>{
    MenuRole create(MenuRole entity);
    MenuRole getById(Long id);
    QueryResult<MenuRole> getAll(int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortings);
    MenuRole update(Long id, MenuRole entity);
}
