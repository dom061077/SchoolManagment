package com.sms.smr.domain.service.academic;

import java.util.Optional;

import com.sms.smr.domain.model.PageResponse;
import com.sms.smr.domain.model.academic.Teacher;
import com.sms.smr.domain.ports.in.BaseUseCase;
import com.sms.smr.domain.ports.out.CrudPersistenceOutputPort;
import com.sms.smr.domain.ports.out.QueryPersistenceOutputPort;
import com.sms.smr.domain.exception.EntityNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TeacherService implements BaseUseCase<Teacher, Long> {

    private final CrudPersistenceOutputPort<Teacher, Long> crudOutputPort;
    private final QueryPersistenceOutputPort<Teacher, Long> queryOutputPort;

    @Override
    public Teacher create(Teacher entity) {
        return crudOutputPort.save(entity);
    }

    @Override
    public Optional<Teacher> getById(Long id) {
        return crudOutputPort.getById(id);
    }

    @Override
    public Teacher update(Long id, Teacher domain) {
        if (crudOutputPort.getById(id).isPresent()) {
            domain.setId(id);
            return crudOutputPort.update(id, domain).orElseThrow(() ->
                new EntityNotFoundException("Error updating Teacher with id " + id)
            );
        }
        throw new EntityNotFoundException("Teacher with id " + id + " not found");
    }

    @Override
    public boolean delete(Long id) {
        if (crudOutputPort.getById(id).isPresent()) {
            return crudOutputPort.delete(id).isPresent();
        }
        throw new EntityNotFoundException("Teacher with id " + id + " not found");
    }

    @Override
    public PageResponse<Teacher> getAll(int offset, int limit, String queryFilters, String sortings,
            String loperator) {
        return queryOutputPort.getAll(offset, limit, queryFilters, sortings, loperator);
    }
}
