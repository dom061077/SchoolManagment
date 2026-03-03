package com.sms.smr.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.sms.smr.domain.model.Student;
import com.sms.smr.domain.ports.in.BaseUseCase;
import com.sms.smr.domain.ports.out.CrudPersistenceOutputPort;
import com.sms.smr.infra.exception.InternalServerErrorException;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.ouput.persistence.student.StudentQueryAdapter;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryResult;

import lombok.RequiredArgsConstructor;


/*
 * In this class we connect inputport with outputport.
 * 
 */
@Service
@RequiredArgsConstructor
public class StudentService implements BaseUseCase<Student, Long> {
    private final CrudPersistenceOutputPort<Student, Long> crudOutputPort;
    private final StudentQueryAdapter studentQueryJpaRepository;


   /* public StudentUseCase(CrudOutputPort<Student, Long> crudOutputPort) {
        this.crudOutputPort = crudOutputPort;
    } */  
    @Override
    public Student create(Student student) {
        return crudOutputPort.save(student);
    }

    @Override
    public Optional<Student> getById(Long id) {
        return crudOutputPort.getById(id);
    }

    @Override
    public Page<Student> getAll(int offset, int limit, String queryFilters, String sortings, String loperator) {
        return studentQueryJpaRepository.getAll(offset, limit, queryFilters, sortings, loperator);
    }

    @Override
    public Student update(Long id, Student student) {
        if(crudOutputPort.getById(id).isPresent()){
            student.setId(id);
            return crudOutputPort.update(id,student).get(); 
        }
            
        throw new InternalServerErrorException("Student with id "+id+" not found");
    }

    @Override
    public boolean delete(Long id){
        if(crudOutputPort.getById(id).isPresent()){
            return crudOutputPort.delete(id).isPresent();
        }

        throw new InternalServerErrorException("Student with id: "+id+" not found");
    }
}