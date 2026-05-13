package com.sms.smr.domain.model.academic;

import java.math.BigDecimal;

import com.sms.smr.domain.model.BaseDomain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SchoolExamDetail extends BaseDomain {
    private Long schoolExamId;
    private Long academicPeriodId;
    private BigDecimal score;
    private Long studentRegistrationId;
}
