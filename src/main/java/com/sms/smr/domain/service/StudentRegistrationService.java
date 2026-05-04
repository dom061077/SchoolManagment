package com.sms.smr.domain.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sms.smr.domain.model.StudentRegistration;
import com.sms.smr.domain.ports.in.BaseUseCase;
import com.sms.smr.domain.ports.out.CrudPersistenceOutputPort;
import com.sms.smr.domain.ports.out.QueryPersistenceOutputPort;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentRegistrationService implements BaseUseCase<StudentRegistration, Long> {
    public final CrudPersistenceOutputPort<StudentRegistration, Long> crudOutputPort;
    // public final StudentRegistrationRepositoryAdapter crudOutputPort;
    public final QueryPersistenceOutputPort<StudentRegistration, Long> queryRepository;
    // public final StudentRegistrationrQueryJpaRepository queryRepository;

    @Override
    @Transactional
    public StudentRegistration create(StudentRegistration studentRegistration) {
        return crudOutputPort.save(studentRegistration);
    }

    @Override
    public Optional<StudentRegistration> getById(Long id) {
        return crudOutputPort.getById(id);
    }

    @Override
    @Transactional
    public StudentRegistration update(Long id, StudentRegistration domain) {
        return crudOutputPort.update(id, domain).get();

    }

    @Override
    @Transactional
    public boolean delete(Long id) {

        return crudOutputPort.delete(id).isPresent();
    }

    @Override
    public Page<StudentRegistration> getAll(int offset, int limit, String queryFilters, String sortings,
            String loperator) {
        // throw new UnsupportedOperationException("Unimplemented method 'getAll'");
        return queryRepository.getAll(offset, limit, queryFilters, sortings, loperator);
    }
}
