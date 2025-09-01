package com.sms.smr.infra.outputadapter.jparepository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface SpringDataRepository<T> extends JpaRepository<T, Long> {

}
