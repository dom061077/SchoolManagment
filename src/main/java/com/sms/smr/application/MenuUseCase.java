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
        // TODO Auto-generated method stub
        return menuEntityMapper.entityToDomain(entityRepository.save(menuEntityMapper.domainToEntity(entity)));
    }

    @Override
    public Optional<Menu> getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public QueryResult<Menu> getAll(int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortings) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Optional<Menu> update(Long id, Menu entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    


}
