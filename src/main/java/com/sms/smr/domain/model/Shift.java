package com.sms.smr.domain.model;

import com.sms.smr.infra.ouput.persistence.gradelevel.GradeLevelEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shift {
    private Long id;
    private String name;

}
