package com.sms.smr.infra.outputadapter.repositoryadapter.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.smr.infra.outputadapter.db.MenuRoleEntity;

public interface SpringDataMenuRoleRepository extends JpaRepository<MenuRoleEntity, Long> {

}
