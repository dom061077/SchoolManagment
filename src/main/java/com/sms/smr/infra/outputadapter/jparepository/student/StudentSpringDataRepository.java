package com.sms.smr.infra.outputadapter.jparepository.student;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.smr.infra.outputadapter.db.StudentEntity;


//No hace falta ninguna anotación spring autodetecta que se trata de un Bean cuando una interface hereda de JpaRepository
public interface StudentSpringDataRepository extends JpaRepository<StudentEntity, Long>{

}
