package com.sms.smr.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sms.smr.domain.Student;
import com.sms.smr.infra.exception.InternalServerErrorException;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.inputport.StudentInputPort;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;
import com.sms.smr.infra.outputport.CrudOutputPort;


/*
 * In this class we connect inputport with outputport.
 * 
 */
@Service
public class StudentUseCase implements StudentInputPort {
    private final CrudOutputPort<Student, Long> crudOutputPort;

    public StudentUseCase(CrudOutputPort<Student, Long> crudOutputPort) {
        this.crudOutputPort = crudOutputPort;
    }   
    @Override
    public Student create(Student student) {
        return crudOutputPort.save(student);
    }

    @Override
    public Optional<Student> getById(Long id) {
        return crudOutputPort.getById(id);
    }

    @Override
    public QueryResult<Student> getAll(int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortings) {
        return crudOutputPort.getAll(offset, limit, queryFilters, queryFilters);
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
    public boolean delete(Long id, Student student){
        if(crudOutputPort.getById(id).isPresent()){
            student.setId(id);
            student.setDeleted(true);
            return crudOutputPort.update(id, student).isPresent();
        }

        throw new InternalServerErrorException("Student with id: "+id+" not found");
    }
}