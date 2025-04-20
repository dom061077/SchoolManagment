package com.sms.smr.infra.outputadapter.jparepository.user;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.db.MenuRoleEntity;
import com.sms.smr.infra.outputadapter.db.PersonEntity;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepository;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component(value = "menuRoleRepository")
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
       return  queryRepository.getAllAnd(MenuRoleEntity.class, offset, limit, queryFilters, sortFilters);

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
