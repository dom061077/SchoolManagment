package com.sms.smr.infra.ouput.persistence.student;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.Student;
import com.sms.smr.infra.ouput.persistence.BaseRepository;

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
