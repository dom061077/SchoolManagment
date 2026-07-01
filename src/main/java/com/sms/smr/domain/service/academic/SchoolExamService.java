package com.sms.smr.domain.service.academic;

import java.util.Optional;

import com.sms.smr.domain.model.PageResponse;

import com.sms.smr.domain.model.academic.SchoolExam;
import com.sms.smr.domain.ports.in.BaseUseCase;
import com.sms.smr.domain.ports.out.CrudPersistenceOutputPort;
import com.sms.smr.domain.ports.out.QueryPersistenceOutputPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SchoolExamService implements BaseUseCase<SchoolExam, Long> {

    public final CrudPersistenceOutputPort<SchoolExam, Long> crudOutputPort;
    public final QueryPersistenceOutputPort<SchoolExam, Long> queryRepository;

    @Override
    public SchoolExam create(SchoolExam domain) {
        return crudOutputPort.save(domain);
    }

    @Override
    public Optional<SchoolExam> getById(Long id) {
        return crudOutputPort.getById(id);
    }

    @Override
    public SchoolExam update(Long id, SchoolExam domain) {
        return crudOutputPort.update(id, domain).get();
    }

    @Override
    public boolean delete(Long id) {
        return crudOutputPort.delete(id).isPresent();
    }

    @Override
    public PageResponse<SchoolExam> getAll(int offset, int limit, String queryFilters, String sortings, String loperator) {
        return queryRepository.getAll(offset, limit, queryFilters, sortings, loperator);
    }
}
