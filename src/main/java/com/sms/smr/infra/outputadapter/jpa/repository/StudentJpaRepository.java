package com.sms.smr.infra.outputadapter.jpa.repository;

import com.sms.smr.infra.outputadapter.db.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentJpaRepository extends JpaRepository<StudentEntity, Long> , JpaSpecificationExecutor<StudentEntity>{

}
