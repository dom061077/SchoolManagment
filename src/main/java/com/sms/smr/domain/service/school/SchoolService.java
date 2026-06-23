package com.sms.smr.domain.service.school;

import java.util.Optional;

import com.sms.smr.domain.model.PageResponse;
import org.springframework.stereotype.Service;

import com.sms.smr.domain.model.School;
import com.sms.smr.domain.ports.in.BaseUseCase;
import com.sms.smr.domain.ports.out.CrudPersistenceOutputPort;
import com.sms.smr.domain.ports.out.QueryPersistenceOutputPort;
import com.sms.smr.infra.exception.ApiException;
import com.sms.smr.infra.exception.InternalServerErrorException;
import com.sms.smr.infra.ouput.persistence.school.SchoolEntity;
import com.sms.smr.infra.ouput.persistence.school.SchoolJpaRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolService implements BaseUseCase<School, Long> {

    private final QueryPersistenceOutputPort<School, Long> queryOutputPort;
    private final SchoolJpaRepository schoolJpaRepository;

    @Override
    public School create(School entity) {
        /*
        validateCueUniqueness(entity.getCue(), null);
        return crudOutputPort.save(entity);
        */
       throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public Optional<School> getById(Long id) {
        //return crudOutputPort.getById(id);
        throw new UnsupportedOperationException("Method not implemented");  
    }

    @Override
    public School update(Long id, School domain) {
        /*
        if (crudOutputPort.getById(id).isPresent()) {
            validateCueUniqueness(domain.getCue(), id);
            domain.setId(id);
            return crudOutputPort.update(id, domain).get();
        }
        throw new InternalServerErrorException("School with id " + id + " not found");
        */
       throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public boolean delete(Long id) {
        /*
        if (crudOutputPort.getById(id).isPresent()) {
            return crudOutputPort.delete(id).isPresent();
        }
        throw new InternalServerErrorException("School with id " + id + " not found");
        */
       throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public PageResponse<School> getAll(int offset, int limit, String queryFilters, String sortings, String loperator) {
        return queryOutputPort.getAll(offset, limit, queryFilters, sortings, loperator);
    }

    private void validateCueUniqueness(String cue, Long excludeId) {
        Optional<SchoolEntity> existingSchool = schoolJpaRepository.findByCue(cue);
        if (existingSchool.isPresent()) {
            if (excludeId == null || !existingSchool.get().getId().equals(excludeId)) {
                throw new ApiException(400, "SMR001", "School with CUE " + cue + " already exists");
            }
        }
    }
}
