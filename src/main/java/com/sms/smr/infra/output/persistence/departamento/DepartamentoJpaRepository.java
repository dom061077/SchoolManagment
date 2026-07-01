package com.sms.smr.infra.output.persistence.departamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface DepartamentoJpaRepository extends JpaRepository<DepartamentoEntity, Long>, JpaSpecificationExecutor<DepartamentoEntity> {

}
