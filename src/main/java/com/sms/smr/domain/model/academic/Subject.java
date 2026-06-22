package com.sms.smr.domain.model.academic;

import com.sms.smr.domain.model.GradeLevel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    private String name;
    private Teacher teacher;
    private GradeLevel gradeLevel;


}
