package com.sms.smr.infra.outputadapter.jparepository.alumno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.sms.smr.infra.outputadapter.db.AlumnoEntity;

@Component
public interface SpringDataAlumnoRepository extends JpaRepository<AlumnoEntity,Long> {
    
    

}
