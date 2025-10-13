package com.sms.smr.infra.outputadapter.db.school;

import com.sms.smr.infra.outputadapter.db.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="curso")
public class SchoolYearEntityEntity extends BaseEntity{
    private String description;
}
