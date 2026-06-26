package com.sms.smr.infra.ouput.persistence.academic.teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeacherJpaRepository extends JpaRepository<TeacherEntity, Long>,
        JpaSpecificationExecutor<TeacherEntity> {

}
