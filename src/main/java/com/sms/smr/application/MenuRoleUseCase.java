package com.sms.smr.application;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sms.smr.infra.inputport.BaseInputPort;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;

@Component(value = "menuRoleUseCase")
@RequiredArgsConstructor
public class MenuRoleUseCase implements BaseInputPort{

    private static final Logger logger = LoggerFactory.getLogger(MenuRoleUseCase.class);

    @Qualifier(value="menuRoleRepository")
    private final EntityRepository entityRepository;

    @Override
    public Object create(Object entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Object getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public QueryResult getAll(int offset, int limit, List queryFilters, List sortings) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Object update(Long id, Object entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
