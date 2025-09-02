package com.sms.smr.infra.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.smr.infra.outputadapter.db.StudentEntity;

public interface StudentJpaRepository extends JpaRepository<StudentEntity, Long>{

}
