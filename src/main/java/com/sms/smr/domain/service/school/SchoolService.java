package com.sms.smr.domain.service.school;

import java.util.Optional;

import com.sms.smr.domain.model.PageResponse;
import com.sms.smr.domain.model.School;
import com.sms.smr.domain.ports.in.BaseUseCase;
import com.sms.smr.domain.ports.out.CrudPersistenceOutputPort;
import com.sms.smr.domain.ports.out.SchoolQueryPersistenceOutputPort;
import com.sms.smr.domain.exception.EntityNotFoundException;
import com.sms.smr.domain.exception.DomainException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SchoolService implements BaseUseCase<School, Long> {

    private final SchoolQueryPersistenceOutputPort queryOutputPort;
    private final CrudPersistenceOutputPort<School, Long> crudOutputPort;

    @Override
    public School create(School entity) {
        validateCueUniqueness(entity.getCue(), null);
        return crudOutputPort.save(entity);
    }

    @Override
    public Optional<School> getById(Long id) {
        return crudOutputPort.getById(id);
    }

    @Override
    public School update(Long id, School domain) {
        if (crudOutputPort.getById(id).isPresent()) {
            validateCueUniqueness(domain.getCue(), id);
            domain.setId(id);
            return crudOutputPort.update(id, domain).orElseThrow(() ->
                new EntityNotFoundException("Error updating School with id " + id)
            );
        }
        throw new EntityNotFoundException("School with id " + id + " not found");
    }

    @Override
    public boolean delete(Long id) {
        if (crudOutputPort.getById(id).isPresent()) {
            return crudOutputPort.delete(id).isPresent();
        }
        throw new EntityNotFoundException("School with id " + id + " not found");
    }

    @Override
    public PageResponse<School> getAll(int offset, int limit, String queryFilters, String sortings, String loperator) {
        return queryOutputPort.getAll(offset, limit, queryFilters, sortings, loperator);
    }

    private void validateCueUniqueness(String cue, Long excludeId) {
        Optional<School> existingSchool = queryOutputPort.findByCue(cue);
        if (existingSchool.isPresent()) {
            if (excludeId == null || !existingSchool.get().getId().equals(excludeId)) {
                throw new DomainException("School with CUE " + cue + " already exists");
            }
        }
    }
}


