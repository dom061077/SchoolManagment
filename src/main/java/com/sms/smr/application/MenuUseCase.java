package com.sms.smr.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sms.smr.domain.Menu;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.inputport.BaseInputPort;
import com.sms.smr.infra.outputadapter.db.MenuEntity;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepository;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;
import com.sms.smr.infra.outputadapter.mapper.MenuEntityMapper;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;

@Component(value = "menuUseCase")
@RequiredArgsConstructor
public class MenuUseCase implements BaseInputPort<Menu> {

    private final EntityRepository<MenuEntity> entityRepository;
    private final QueryRepository queryRepository;
    private final MenuEntityMapper menuEntityMapper;

    public Menu create(Menu entity) {
        
        return menuEntityMapper.entityToDomain(entityRepository.save(menuEntityMapper.domainToEntity(entity)));
    }

    @Override
    public Optional<Menu> getById(Long id) {
        return entityRepository.getById(id)
                .map(menuEntity -> menuEntityMapper.entityToDomain((MenuEntity) menuEntity));
    }

    @Override
    public QueryResult<Menu> getAll(int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortings) {
        QueryResult<Menu> qResult = new QueryResult<Menu>();

        qResult.setData(menuEntityMapper.getMenus(queryRepository.getAllAnd(MenuEntity.class, offset, limit, queryFilters, sortings)));
        long count = entityRepository.getCount(queryFilters);
        qResult.setTotal(count);

        return qResult;
    }

    @Override
    public Optional<Menu> update(Long id, Menu entity) {
        return entityRepository.update(id, menuEntityMapper.domainToEntity(entity))
                .map(menuEntityMapper::entityToDomain);
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

    


}
