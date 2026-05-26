package com.sms.smr.domain.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.sms.smr.domain.model.Student;
import com.sms.smr.domain.ports.in.StudentUseCase;
import com.sms.smr.domain.ports.out.CrudPersistenceOutputPort;
import com.sms.smr.domain.ports.out.StudentQueryPersistenceOutputPort;
import com.sms.smr.infra.exception.InternalServerErrorException;

import lombok.RequiredArgsConstructor;

/*
 * In this class we connect inputport with outputport.
 * 
 */
@Service
@RequiredArgsConstructor
public class StudentService implements StudentUseCase {
    private final CrudPersistenceOutputPort<Student, Long> crudOutputPort;
    private final StudentQueryPersistenceOutputPort studentQueryJpaRepository;

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
    public Page<Student> searchStudents(Integer dni, String lastName, String firstName, int page, int size) {
        return studentQueryJpaRepository.searchStudents(dni, lastName, firstName, page, size);
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