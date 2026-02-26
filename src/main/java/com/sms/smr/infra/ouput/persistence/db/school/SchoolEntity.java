package com.sms.smr.infra.ouput.persistence.db.school;

import com.sms.smr.infra.ouput.persistence.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Entity
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Table(name="escuela")
public class SchoolEntity extends BaseEntity {

    @NotNull
    private String name;
    @NotNull
    private String cue;
}
