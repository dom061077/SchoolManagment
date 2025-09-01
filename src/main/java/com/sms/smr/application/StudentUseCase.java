package com.sms.smr.application;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sms.smr.domain.Student;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.inputport.BaseInputPort;
import com.sms.smr.infra.outputadapter.db.StudentEntity;
import com.sms.smr.infra.outputadapter.db.LocalidadEntity;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepository;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;
import com.sms.smr.infra.outputadapter.mapper.StudentEntityMapper;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component(value = "studentUseCase")
public class StudentUseCase implements BaseInputPort<Student> {
    private static final Logger logger = LoggerFactory.getLogger(StudentUseCase.class);
    
    @Qualifier(value = "studentRepository")
    private final EntityRepository<StudentEntity> entityRepository;
    private final EntityRepository<LocalidadEntity> localidadRepository;
    private final QueryRepository<StudentEntity> queryRepository;
    private final StudentEntityMapper studentEntityMapper;

    @Override
    public Student create(Student domain) {
        StudentEntity studentEntity = studentEntityMapper.toEntity(domain);
        if(domain.getLocalidadId() != null) {
            LocalidadEntity localidadEntity = localidadRepository.getById(domain.getLocalidadId()).orElseThrow();
            studentEntity.setLocalidadEntity(localidadEntity);
        }
        return studentEntityMapper.toDomain(entityRepository.save(studentEntity));
    }

    @Override
    public Optional<Student> getById(Long id) {
        Optional<StudentEntity> studentEntityOpt = entityRepository.getById(id);
        if(studentEntityOpt.isEmpty()) {    
            return Optional.empty();
        }
        return studentEntityOpt.map(studentEntityMapper::toDomain);
        //return studentEntityOpt.map(studentEntity -> studentEntityMapper.toDomain(studentEntity));
    }

    @Override
    public QueryResult<Student> getAll(int offset, int limit, List<QueryDto> queryFilters, List<QueryDto> sortings) {
        QueryResult<Student> qResult = new QueryResult<Student>();            
        qResult.setData( studentEntityMapper.getDomainList( queryRepository.getAllAnd(StudentEntity.class, offset, limit, queryFilters, sortings) ) );
        long count = entityRepository.getCount(queryFilters);   
        qResult.setTotal(count);
        return qResult;
    }

    @Override
    public Optional<Student> update(Long id, Student entity) {
        StudentEntity studentEntity = studentEntityMapper.toEntity(entity);
        if(entity.getLocalidadId() != null) {
            LocalidadEntity localidadEntity = localidadRepository.getById(entity.getLocalidadId()).orElseThrow();
            studentEntity.setLocalidadEntity(localidadEntity);
        }   
        return entityRepository.update(id, studentEntity).map(studentEntityMapper::toDomain);
    }

    @Override
    public boolean delete(Long id) {
        Optional<StudentEntity> deletedStudent = entityRepository.delete(id);
        if(deletedStudent.isEmpty())
            return false;
        return true;
        
    }

    
}
