package com.sms.smr.domain.model.academic;

import com.sms.smr.domain.model.BaseDomain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AcademicYear extends BaseDomain {
    private int year;
    private boolean isActive;
}
