package com.sms.smr.infra.outputadapter.repositoryadapter.user;

import java.nio.channels.UnsupportedAddressTypeException;
import java.util.List;
import java.util.Optional;

import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.db.MenuRoleEntity;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryRepository;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
//@Component(value = "menuRoleRepository") Deprecated. El menu se maneja desde angular
public class MenuRoleRepository implements EntityRepository<MenuRoleEntity> {

    private final SpringDataMenuRoleRepository sMenuRoleRepository;
    private final QueryRepository queryRepository;
    
    @Override
    public MenuRoleEntity save(MenuRoleEntity reg) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public  Optional<MenuRoleEntity> getById(Long id) {
        return  sMenuRoleRepository.findById(id);
    }

    @Override
    public  List<MenuRoleEntity> getAll(int offset, int limit, List<QueryDto> queryFilters,
            List<QueryDto> sortFilters) {
       //return  queryRepository.getAllAnd(MenuRoleEntity.class, offset, limit, queryFilters, sortFilters);
       throw new UnsupportedAddressTypeException();

    }

    @Override
    public  Optional<MenuRoleEntity> update(Long id, MenuRoleEntity reg) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public long getCount(List<QueryDto> queryFilters) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCount'");
    }

    @Override
    public Optional<MenuRoleEntity> delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
