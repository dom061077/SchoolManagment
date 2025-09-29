package com.sms.smr.infra.outputadapter.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@SuperBuilder
@Builder
@Getter
@Setter
@NoArgsConstructor
@Table(name = "menu_role")
public class MenuRoleEntity extends BaseEntity {

    
    @ManyToOne
    MenuEntity menu;
    
    String role;
    @Column(name = "create_per")
    boolean create;
    boolean update;
    boolean delete;

}
