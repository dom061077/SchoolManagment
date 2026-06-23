package com.sms.smr.domain.model.academic;

import java.time.LocalDate;
import java.util.List;

import com.sms.smr.domain.model.BaseDomain;

import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class SchoolExam extends BaseDomain {
    private String name;
    private String description;
    private LocalDate date;

    @NotNull
    private Long tipoExamenId;
    private String tipoExamenName;

    @NotNull
    private Long academicPeriodId;

    @NotNull
    private Long subjectId;
    private String subjectName;

    private Long teacherId;

    private List<SchoolExamDetail> details;

}
