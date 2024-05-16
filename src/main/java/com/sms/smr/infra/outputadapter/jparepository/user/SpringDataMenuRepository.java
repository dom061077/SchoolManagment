package com.sms.smr.infra.outputadapter.jparepository.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.sms.smr.domain.Role;

import com.sms.smr.infra.outputadapter.db.MenuEntity;

@Component
public interface SpringDataMenuRepository extends JpaRepository<MenuEntity,Long>{
    Optional<List<Role>>  findByRole(String code);
}
