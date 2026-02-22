package com.sms.smr.application;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.sms.smr.domain.MenuRole;
import com.sms.smr.infra.inputadapter.dto.menurole.MenuRoleDto;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.inputadapter.mapper.MenuRoleMapper;
import com.sms.smr.infra.inputport.BaseInputPort;
import com.sms.smr.infra.outputadapter.db.MenuRoleEntity;
import com.sms.smr.infra.outputadapter.mapper.CycleAvoidingMappingContext;
import com.sms.smr.infra.outputadapter.mapper.MenuRoleEntityMapper;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryResult;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;

//@Component(value = "menuRoleUseCase") Deprecated El menu se maneja desde angular.
@RequiredArgsConstructor
public class MenuRoleUseCase implements BaseInputPort<MenuRole,Long>{

    private static final Logger logger = LoggerFactory.getLogger(MenuRoleUseCase.class);
    private final MenuRoleMapper menuRoleMapper;
    private final MenuRoleEntityMapper menuRoleEntityMapper;

    @Qualifier(value="menuRoleRepository")
    private final EntityRepository<MenuRoleEntity> entityRepository;

    @Override
    public MenuRole create(MenuRole menuRole) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Optional<MenuRole> getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public QueryResult getAll(int offset, int limit, List queryFilters, List sortings) {
        // TODO Auto-generated method stub
        QueryResult<MenuRole> qResult = new QueryResult<MenuRole>();
        List<MenuRole> menuRoleList = menuRoleEntityMapper.getDomainList(entityRepository.getAll(offset, limit, queryFilters, sortings), new CycleAvoidingMappingContext());
                //menuRoleMapper.getMenuRoleDtos( 
                //menuRoleEntityMapper.getMenuRoles(entityRepository.getAll(offset, limit, queryFilters, sortings)));
        qResult.setData(menuRoleList);
        qResult.setTotal(qResult.getData().size()); 
        return qResult;

    }

    @Override
    public MenuRole update(Long id, MenuRole entity) {
        // Implement the update logic here
        /*
        MenuRole updatedMenuRole = entityRepository.update(id, entity)
                .orElseThrow(() -> new IllegalArgumentException("MenuRole not found for id: " + id));
        return menuRoleMapper.toDto(updatedMenuRole);
        */
        //return entityRepository.update(personId, personEntityMapper.toDbo(person))
        //        .map(personEntityMapper::toDomain);

        //return entityRepository.update(id, menuRoleEntityMapper.toDbo(entity))
        //        .map(menuRoleEntityMapper::toDomain);        

       // return entityRepository.update(id,menuRoleEntityMapper.toEntity(entity, new CycleAvoidingMappingContext()))
       //         .map(mr->menuRoleEntityMapper.toDomain(mr, new CycleAvoidingMappingContext())); // Convert to domain object
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Long id) {
        
        Optional<MenuRoleEntity> deletedMenuRole = entityRepository.getById(id);
        if(deletedMenuRole.isEmpty())
            return false;
        return true;
    }

    @Override
    public Page<MenuRole> getAll(int offset, int limit, String queryFilters, String sortings,
            String loperator) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }


    
}
