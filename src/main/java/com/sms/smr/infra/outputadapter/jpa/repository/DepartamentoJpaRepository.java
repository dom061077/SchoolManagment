package com.sms.smr.infra.outputadapter.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.smr.infra.outputadapter.db.DepartamentoEntity;


public interface DepartamentoJpaRepository extends JpaRepository<DepartamentoEntity, Long> {

}
