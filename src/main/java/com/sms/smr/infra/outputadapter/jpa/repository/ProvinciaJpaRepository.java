package com.sms.smr.infra.outputadapter.jpa.repository;

import com.sms.smr.infra.outputadapter.db.ProvinciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProvinciaJpaRepository extends JpaRepository<ProvinciaEntity, Long>, JpaSpecificationExecutor<ProvinciaEntity>{

}
