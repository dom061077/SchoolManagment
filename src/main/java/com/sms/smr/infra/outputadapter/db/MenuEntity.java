package com.sms.smr.infra.outputadapter.db;



import jakarta.persistence.Entity;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Table(name="menu")
public class MenuEntity extends BaseEntity { 


    private String description;
    private String code;
    private String path;

}
