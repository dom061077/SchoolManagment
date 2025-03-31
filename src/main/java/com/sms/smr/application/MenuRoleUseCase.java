package com.sms.smr.application;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sms.smr.domain.MenuRole;
import com.sms.smr.infra.inputadapter.dto.menurole.MenuRoleDto;
import com.sms.smr.infra.inputadapter.mapper.MenuRoleMapper;
import com.sms.smr.infra.inputport.BaseInputPort;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;
import com.sms.smr.infra.outputadapter.mapper.MenuRoleEntityMapper;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;

@Component(value = "menuRoleUseCase")
@RequiredArgsConstructor
public class MenuRoleUseCase implements BaseInputPort<MenuRole>{

    private static final Logger logger = LoggerFactory.getLogger(MenuRoleUseCase.class);
    private final MenuRoleMapper menuRoleMapper;
    private final MenuRoleEntityMapper menuRoleEntityMapper;

    @Qualifier(value="menuRoleRepository")
    private final EntityRepository entityRepository;

    @Override
    public MenuRole create(MenuRole menuRole) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public MenuRole getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public QueryResult getAll(int offset, int limit, List queryFilters, List sortings) {
        // TODO Auto-generated method stub
        QueryResult<MenuRoleDto> qResult = new QueryResult<MenuRoleDto>();
        List<MenuRoleDto> menuRoleDtoList = menuRoleMapper.getMenuRoleDtos( 
                menuRoleEntityMapper.getMenuRoles(entityRepository.getAll(offset, limit, queryFilters, sortings)));
        qResult.setData(menuRoleDtoList);
        qResult.setTotal(qResult.getData().size()); 
        return qResult;

    }

    @Override
    public MenuRole update(Long id, MenuRole entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }


    
}
