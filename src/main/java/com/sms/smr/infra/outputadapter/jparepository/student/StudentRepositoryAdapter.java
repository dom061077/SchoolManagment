package com.sms.smr.infra.outputadapter.jparepository.student;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.Student;
import com.sms.smr.infra.jpa.BaseRepository;
import com.sms.smr.infra.jpa.repository.StudentJpaRepository;
import com.sms.smr.infra.outputadapter.db.StudentEntity;
import com.sms.smr.infra.outputadapter.mapper.StudentEntityMapper;

@Repository
public class StudentRepositoryAdapter extends BaseRepository<Student, Long, StudentEntity, StudentJpaRepository> {

    

    public StudentRepositoryAdapter(StudentJpaRepository repository, StudentEntityMapper mapper){
        super(repository,mapper) ;
            
    }

}
