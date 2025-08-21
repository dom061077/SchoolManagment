package com.sms.smr.infra.outputadapter.jparepository.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.sms.smr.infra.outputadapter.db.StudentEntity;

@Component
public interface SpringDataAlumnoRepository extends JpaRepository<StudentEntity,Long> {
    
    

}
