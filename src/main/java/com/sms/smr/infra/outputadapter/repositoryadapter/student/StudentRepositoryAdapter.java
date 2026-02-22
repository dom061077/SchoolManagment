package com.sms.smr.infra.outputadapter.repositoryadapter.student;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.Student;
import com.sms.smr.infra.outputadapter.db.StudentEntity;
import com.sms.smr.infra.outputadapter.jpa.BaseRepository;
import com.sms.smr.infra.outputadapter.jpa.repository.StudentJpaRepository;
import com.sms.smr.infra.outputadapter.jpa.repository.query.StudentQueryJpaRepository;
import com.sms.smr.infra.outputadapter.mapper.StudentEntityMapper;

@Repository
public class StudentRepositoryAdapter extends BaseRepository<Student, Long, StudentEntity, StudentJpaRepository>{

    /*
        scanner de beans de spring boot instancia el mapper y lo pasa como parámetro
        al constructor de BaseRepository
     */    

    public StudentRepositoryAdapter(StudentJpaRepository repository, StudentEntityMapper mapper) {
        
        super(repository,mapper, StudentEntity.class);
            
    }

}
