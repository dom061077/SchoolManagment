package com.sms.smr.application;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.sms.smr.domain.Menu;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.inputport.BaseInputPort;
import com.sms.smr.infra.outputadapter.db.MenuEntity;
import com.sms.smr.infra.outputadapter.mapper.CycleAvoidingMappingContext;
import com.sms.smr.infra.outputadapter.mapper.MenuEntityMapper;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryRepository;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryResult;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;

//@Component(value = "menuUseCase") Deprecated El menu se maneja desde angular.
@RequiredArgsConstructor
public class MenuUseCase implements BaseInputPort<Menu, Long> {

    private final EntityRepository<MenuEntity> entityRepository;
    private final QueryRepository queryRepository;
    private final MenuEntityMapper menuEntityMapper;

    public Menu create(Menu domain) {
        
        return menuEntityMapper.toDomain(entityRepository.save(menuEntityMapper.toEntity(domain, new CycleAvoidingMappingContext())), new CycleAvoidingMappingContext());
    }

    @Override
    public Optional<Menu> getById(Long id) {
        return entityRepository.getById(id)
                .map(menuEntity -> menuEntityMapper.toDomain((MenuEntity) menuEntity, new CycleAvoidingMappingContext()));
    }

    @Override
    public QueryResult<Menu> getAll(int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortings) {
        QueryResult<Menu> qResult = new QueryResult<Menu>();

        qResult.setData(menuEntityMapper.getDomainList(queryRepository.getAllAnd(MenuEntity.class, offset, limit, queryFilters, sortings), new CycleAvoidingMappingContext()));
        long count = entityRepository.getCount(queryFilters);
        qResult.setTotal(count);

        return qResult;
    }

    @Override
    public Menu update(Long id, Menu entity) {
        //return null;
        //return entityRepository.update(id, menuEntityMapper.toEntity(entity, new CycleAvoidingMappingContext()))
        //        .map(menuEntity -> menuEntityMapper.toDomain(menuEntity, new CycleAvoidingMappingContext()));
                //.map(menuEntityMapper::toDomain, new CycleAvoidingMappingContext());
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Long id) {
        Optional<MenuEntity> deletedMenu = entityRepository.getById(id);
        if(deletedMenu.isPresent()) {
            entityRepository.delete(id);
            return true;
        }   
        return false;
    }

    @Override
    public Page<Menu> getAll(int offset, int limit, String queryFilters, String sortings,
            String loperator) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    


}
