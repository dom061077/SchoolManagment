package com.sms.smr.infra.outputadapter.jparepository.student;

import com.sms.smr.domain.Student;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.db.PersonEntity;
import com.sms.smr.infra.outputadapter.db.StudentEntity;
import com.sms.smr.infra.outputadapter.jparepository.SpringDataRespository;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepository;
import com.sms.smr.infra.outputport.EntityRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component(value = "studentRepository")
public class StudentRepository implements EntityRepository<StudentEntity> {

    private final SpringDataRespository<StudentEntity> springDataRespository;
    private final QueryRepository<StudentEntity> queryRepository;
    
    @Override
    public StudentEntity save(StudentEntity reg) {
        return springDataRespository.save(reg);
    }

    @Override
    public Optional<StudentEntity> getById(Long id) {
        return springDataRespository.findById(id);
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
        if (springDataRespository.existsById(id)) {
            reg.setId(id);
            return Optional.of(springDataRespository.save(reg));
        }
        return Optional.empty();
    }

    @Override
    public Optional<StudentEntity> delete(Long id) {
        Optional<StudentEntity> studentOptionalEntity = springDataRespository.findById(id);
        if (studentOptionalEntity.isPresent()) {
            studentOptionalEntity.get().setDeleted(true);
            springDataRespository.save(studentOptionalEntity.get());
            
        } else {
            return Optional.empty();
        }
        
        return studentOptionalEntity;        
    }


}
