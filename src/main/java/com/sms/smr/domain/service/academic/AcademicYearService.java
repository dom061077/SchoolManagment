package com.sms.smr.domain.service.academic;

import java.util.Optional;

import com.sms.smr.domain.model.PageResponse;
import org.springframework.stereotype.Service;

import com.sms.smr.domain.model.academic.AcademicYear;
import com.sms.smr.domain.ports.in.BaseUseCase;
import com.sms.smr.domain.ports.out.CrudPersistenceOutputPort;
import com.sms.smr.domain.ports.out.QueryPersistenceOutputPort;
import com.sms.smr.domain.exception.EntityNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AcademicYearService implements BaseUseCase<AcademicYear, Long> {

    private final CrudPersistenceOutputPort<AcademicYear, Long> crudOutputPort;
    private final QueryPersistenceOutputPort<AcademicYear, Long> queryOutputPort;

    @Override
    public AcademicYear create(AcademicYear entity) {
        return crudOutputPort.save(entity);
    }

    @Override
    public Optional<AcademicYear> getById(Long id) {
        return crudOutputPort.getById(id);
    }

    @Override
    public AcademicYear update(Long id, AcademicYear domain) {
        if (crudOutputPort.getById(id).isPresent()) {
            domain.setId(id);
            return crudOutputPort.update(id, domain).get();
        }
        throw new EntityNotFoundException("Academic year with id " + id + " not found");
    }

    @Override
    public boolean delete(Long id) {
        if (crudOutputPort.getById(id).isPresent()) {
            return crudOutputPort.delete(id).isPresent();
        }
        throw new EntityNotFoundException("Academic year with id " + id + " not found");
    }

    @Override
    public PageResponse<AcademicYear> getAll(int offset, int limit, String queryFilters, String sortings,
            String loperator) {
        return queryOutputPort.getAll(offset, limit, queryFilters, sortings, loperator);
    }
}
