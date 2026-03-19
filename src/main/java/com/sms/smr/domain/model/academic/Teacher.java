package com.sms.smr.domain.model.academic;

import com.sms.smr.domain.model.BasePersonDomain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher extends BasePersonDomain {
    private String userName;

}
