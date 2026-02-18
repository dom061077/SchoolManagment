package com.sms.smr.infra.outputadapter.jpa.repository;

import com.sms.smr.infra.outputadapter.db.DepartamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface DepartamentoJpaRepository extends JpaRepository<DepartamentoEntity, Long>, JpaSpecificationExecutor<DepartamentoEntity> {

}
