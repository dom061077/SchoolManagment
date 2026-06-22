package com.sms.smr.infra.outputadapter.repositoryadapter.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.sms.smr.domain.model.Role;
import com.sms.smr.infra.ouput.persistence.db.MenuEntity;

@Component
public interface SpringDataMenuRepository extends JpaRepository<MenuEntity,Long>{
    
}
