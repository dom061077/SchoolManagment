package com.sms.smr.infra.outputadapter.jparepository;


import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataRespository<T> extends JpaRepository<T,Long> {

}
