package com.sms.smr.infra.outputadapter.db;

import com.sms.smr.domain.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name="menu")
public class MenuEntity { 

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    @Enumerated(EnumType.STRING)
    private Role role;
}
