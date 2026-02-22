package com.sms.smr.application;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sms.smr.domain.StudentRegistration;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.inputport.BaseInputPort;
import com.sms.smr.infra.outputadapter.db.academic.StudentRegistrationEntity;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryResult;
import com.sms.smr.infra.outputport.CrudOutputPort;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) 
public class StudentRegistrationUseCase implements BaseInputPort<StudentRegistration, Long>{
    public final CrudOutputPort<StudentRegistration, Long> crudOutputPort;

    @Override
    public StudentRegistration create(StudentRegistration studentRegistration) {
        return crudOutputPort.save(studentRegistration);
    }

    @Override
    public Optional<StudentRegistration> getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public QueryResult<StudentRegistration> getAll(int offset, int limit, List<QueryDto> queryFilters,
            List<QueryDto> sortings) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
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
        //TODO
        throw new UnsupportedOperationException();
    }
}
