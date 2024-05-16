package com.sms.smr.infra.outputadapter.jparepository.user;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sms.smr.infra.inputadapter.dto.query.QueryFilterDto;
import com.sms.smr.infra.outputadapter.db.MenuEntity;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component(value = "menuRepository")
public class MenuRepository implements EntityRepository {

    private final SpringDataMenuRepository sMenuRepository;

    @Override
    public <T> T save(T reg) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public <T> T getById(Long id) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getById'");
        return (T)new MenuEntity();
    }

    @Override
    public <T> List<T> getAll(int offset, int limit, List<QueryFilterDto> queryFilters,
            List<QueryFilterDto> sortFilters) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getAll'");
        return (List<T>)sMenuRepository.findAll();
    }


}
