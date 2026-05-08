package com.sms.smr.domain.service.school;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.sms.smr.domain.model.Section;
import com.sms.smr.domain.ports.in.BaseUseCase;
import com.sms.smr.domain.ports.out.CrudPersistenceOutputPort;
import com.sms.smr.domain.ports.out.QueryPersistenceOutputPort;
import com.sms.smr.infra.exception.InternalServerErrorException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SectionService implements BaseUseCase<Section, Long> {

    private final CrudPersistenceOutputPort<Section, Long> crudOutputPort;
    private final QueryPersistenceOutputPort<Section, Long> queryOutputPort;

    @Override
    public Section create(Section entity) {
        return crudOutputPort.save(entity);
    }

    @Override
    public Optional<Section> getById(Long id) {
        return crudOutputPort.getById(id);
    }

    @Override
    public Section update(Long id, Section domain) {
        if (crudOutputPort.getById(id).isPresent()) {
            domain.setId(id);
            return crudOutputPort.update(id, domain).get();
        }
        throw new InternalServerErrorException("Section with id " + id + " not found");
    }

    @Override
    public boolean delete(Long id) {
        if (crudOutputPort.getById(id).isPresent()) {
            return crudOutputPort.delete(id).isPresent();
        }
        throw new InternalServerErrorException("Section with id " + id + " not found");
    }

    @Override
    public Page<Section> getAll(int offset, int limit, String queryFilters, String sortings,
            String loperator) {
        return queryOutputPort.getAll(offset, limit, queryFilters, sortings, loperator);
    }

}
