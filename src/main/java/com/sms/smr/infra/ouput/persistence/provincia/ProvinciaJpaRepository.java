package com.sms.smr.infra.ouput.persistence.provincia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProvinciaJpaRepository extends JpaRepository<ProvinciaEntity, Long>, JpaSpecificationExecutor<ProvinciaEntity>{

}
