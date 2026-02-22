package com.sms.smr.application;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.sms.smr.domain.Localidad;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.inputport.BaseInputPort;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryResult;
import com.sms.smr.infra.outputport.CrudOutputPort;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class LocalidadUseCase implements BaseInputPort<Localidad, Long> {
    private final CrudOutputPort<Localidad, Long> crudOutputPort;



    @Override
    public QueryResult<Localidad> getAll(int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortings) {
        //TODO
        throw new UnsupportedOperationException();
    }



    @Override
    public Localidad create(Localidad entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }



    @Override
    public Optional<Localidad> getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }



    @Override
    public Localidad update(Long id, Localidad domain) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }



    @Override
    public boolean delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }



    @Override
    public Page<Localidad> getAll(int offset, int limit, String queryFilters, String sortings,
            String loperator) {
        //TODO
        throw new UnsupportedOperationException();
    }

}
