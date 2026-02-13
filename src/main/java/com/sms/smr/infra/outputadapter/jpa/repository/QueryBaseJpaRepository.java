package com.sms.smr.infra.outputadapter.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

@Service
public interface QueryBaseJpaRepository<T,ID> extends JpaRepository<T,ID>, JpaSpecificationExecutor<T> {

}
