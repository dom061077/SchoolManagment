package com.sms.smr.infra.ouput.persistence.localidad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LocalidadJpaRepository extends JpaRepository<LocalidadEntity, Long>, JpaSpecificationExecutor<LocalidadEntity> {

}


