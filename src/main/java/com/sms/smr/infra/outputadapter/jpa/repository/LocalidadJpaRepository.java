package com.sms.smr.infra.outputadapter.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.smr.infra.outputadapter.db.LocalidadEntity;

public interface LocalidadJpaRepository extends JpaRepository<LocalidadEntity, Long> {

}


