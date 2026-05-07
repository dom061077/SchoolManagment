package com.sms.smr.domain.service.school;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.sms.smr.domain.model.GradeLevel;
import com.sms.smr.domain.ports.in.BaseUseCase;
import com.sms.smr.domain.ports.out.CrudPersistenceOutputPort;
import com.sms.smr.domain.ports.out.QueryPersistenceOutputPort;
import com.sms.smr.infra.exception.InternalServerErrorException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GradeLevelService implements BaseUseCase<GradeLevel, Long> {

    private final CrudPersistenceOutputPort<GradeLevel, Long> crudOutputPort;
    private final QueryPersistenceOutputPort<GradeLevel, Long> queryOutputPort;

    @Override
    public GradeLevel create(GradeLevel entity) {
        return crudOutputPort.save(entity);
    }

    @Override
    public Optional<GradeLevel> getById(Long id) {
        return crudOutputPort.getById(id);
    }

    @Override
    public GradeLevel update(Long id, GradeLevel domain) {
        if (crudOutputPort.getById(id).isPresent()) {
            domain.setId(id);
            return crudOutputPort.update(id, domain).get();
        }
        throw new InternalServerErrorException("Grade level with id " + id + " not found");
    }

    @Override
    public boolean delete(Long id) {
        if (crudOutputPort.getById(id).isPresent()) {
            return crudOutputPort.delete(id).isPresent();
        }
        throw new InternalServerErrorException("Grade level with id " + id + " not found");
    }

    @Override
    public Page<GradeLevel> getAll(int offset, int limit, String queryFilters, String sortings,
            String loperator) {
        return queryOutputPort.getAll(offset, limit, queryFilters, sortings, loperator);
    }
}
