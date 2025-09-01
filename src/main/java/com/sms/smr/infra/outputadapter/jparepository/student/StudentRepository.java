package com.sms.smr.infra.outputadapter.jparepository.student;

import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.db.StudentEntity;

import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepository;
import com.sms.smr.infra.outputport.EntityRepository;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;
import com.sms.smr.infra.outputadapter.jparepository.SpringDataRepository;


@Component(value = "studentRepository")
@RequiredArgsConstructor
public class StudentRepository implements EntityRepository<StudentEntity> {

    private final SpringDataRepository<StudentEntity> springDataRepository;

    private final QueryRepository<StudentEntity> queryRepository;
    
    @Override 
    public StudentEntity save(StudentEntity reg) {
        return springDataRepository.save(reg);
    }

    @Override
    public Optional<StudentEntity> getById(Long id) {
        return springDataRepository.findById(id);
    }

    @Override
    public List<StudentEntity> getAll(int offset, int limit, List<QueryDto> queryFilters,List<QueryDto> sortFilters) {
        return queryRepository.getAllAnd(StudentEntity.class, offset, limit, queryFilters, sortFilters);
    }

    @Override
    public long getCount(List<QueryDto> queryFilters) {
        return queryRepository.getCount(StudentEntity.class, queryFilters);
    }

    @Override
    public Optional<StudentEntity> update(Long id, StudentEntity reg) {
        // Implement the update logic here, for example:
        if (springDataRepository.existsById(id)) {
            reg.setId(id);
            return Optional.of(springDataRepository.save(reg));
        }
        return Optional.empty();
    }

    @Override
    public Optional<StudentEntity> delete(Long id) {
        Optional<StudentEntity> studentOptionalEntity = springDataRepository.findById(id);
        if (studentOptionalEntity.isPresent()) {
            studentOptionalEntity.get().setDeleted(true);
            springDataRepository.save(studentOptionalEntity.get());
            
        } else {
            return Optional.empty();
        }
        
        return studentOptionalEntity;        
    }


}
