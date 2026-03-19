package com.sms.smr.domain.model.academic;

import java.time.LocalDate;

import com.sms.smr.domain.model.BaseDomain;
import com.sms.smr.infra.ouput.persistence.academic.AcademicPeriodEntity;
import com.sms.smr.infra.ouput.persistence.academic.SubjectEntity;
import com.sms.smr.infra.ouput.persistence.academic.TeacherEntity;
import com.sms.smr.infra.ouput.persistence.academic.TipoExamenEntity;

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
public class SchoolExam extends BaseDomain {
    private String name;
    private String description;
    private LocalDate date;

    private TipoExamenEntity tipoExamen;
    private AcademicPeriodEntity academicPeriod;
    private SubjectEntity subject;
    private TeacherEntity teacher;

}
