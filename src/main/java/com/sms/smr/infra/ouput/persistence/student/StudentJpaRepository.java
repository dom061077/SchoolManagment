package com.sms.smr.infra.ouput.persistence.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentJpaRepository extends JpaRepository<StudentEntity, Long> , JpaSpecificationExecutor<StudentEntity>{

}
