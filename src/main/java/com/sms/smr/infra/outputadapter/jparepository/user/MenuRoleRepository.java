package com.sms.smr.infra.outputadapter.jparepository.user;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.db.MenuRoleEntity;
import com.sms.smr.infra.outputadapter.db.PersonEntity;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepository;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component(value = "menuRoleRepository")
public class MenuRoleRepository implements EntityRepository {

    private final SpringDataMenuRoleRepository sMenuRoleRepository;
    private final QueryRepository queryRepository;
    
    @Override
    public <T> T save(T reg) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public <T> T getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public <T> List<T> getAll(int offset, int limit, List<QueryDto> queryFilters,
            List<QueryDto> sortFilters) {
       return (List<T>) queryRepository.getAllAnd(MenuRoleEntity.class, offset, limit, queryFilters, sortFilters);

    }

    @Override
    public <T> T update(Long id, T reg) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public long getCount(List<QueryDto> queryFilters) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCount'");
    }
    
}
