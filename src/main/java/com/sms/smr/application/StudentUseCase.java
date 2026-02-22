package com.sms.smr.application;

import com.sms.smr.domain.Student;
import com.sms.smr.infra.exception.InternalServerErrorException;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.inputport.BaseInputPort;
import com.sms.smr.infra.inputport.StudentInputPort;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryResult;
import com.sms.smr.infra.outputport.CrudOutputPort;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


/*
 * In this class we connect inputport with outputport.
 * 
 */
@Service
public class StudentUseCase implements BaseInputPort<Student, Long> {
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
        //TODO
        throw new UnsupportedOperationException();
    }

    @Override
    public Page<Student> getAll(int offset, int limit, String queryFilters, String sortings, String loperator) {
        //TODO
        throw new UnsupportedOperationException();
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