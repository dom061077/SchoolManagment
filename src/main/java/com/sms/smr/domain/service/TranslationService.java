package com.sms.smr.domain.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.sms.smr.domain.model.Translation;
import com.sms.smr.domain.ports.in.BaseUseCase;
import com.sms.smr.domain.ports.out.CrudPersistenceOutputPort;
import com.sms.smr.domain.ports.out.QueryPersistenceOutputPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TranslationService implements BaseUseCase<Translation,Long> {
    private final CrudPersistenceOutputPort<Translation,Long> crudPersistenceOutputPort;
    //private final QueryPersistenceOutputPort<Translation, Long> queryPesistenceOutpuPort;
    @Override
    public Translation create(Translation entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }
    @Override
    public Optional<Translation> getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }
    @Override
    public Translation update(Long id, Translation domain) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    @Override
    public boolean delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    @Override
    public Page<Translation> getAll(int offset, int limit, String queryFilters, String sortings, String loperator) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}
