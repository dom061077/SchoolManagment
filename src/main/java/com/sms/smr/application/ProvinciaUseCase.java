package com.sms.smr.application;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.sms.smr.domain.Provincia;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.inputport.BaseInputPort;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryResult;
import com.sms.smr.infra.outputport.CrudOutputPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProvinciaUseCase implements BaseInputPort<Provincia, Long>{
    private final CrudOutputPort<Provincia, Long> crudOutputPort;

    @Override
    public QueryResult<Provincia> getAll(int offset, int limit, List<QueryDto> qfilters, List<QueryDto> sorts) {
        //TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
        
    }

    @Override
    public Provincia create(Provincia entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Optional<Provincia> getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public Provincia update(Long id, Provincia domain) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<Provincia> getAll(int offset, int limit, String queryFilters, String sortings,
            String loperator) {
        //TODO
        throw new UnsupportedOperationException();
    }

}
