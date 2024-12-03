package com.sms.smr.infra.outputadapter.jparepository.user;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.sms.smr.infra.outputadapter.db.UserEntity;

//@Component
public interface SpringDataUserRepository { //extends JpaRepository<UserEntity,Long> { 
    Optional<UserEntity> findByEmail(String email);
}
