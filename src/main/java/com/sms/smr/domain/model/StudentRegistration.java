package com.sms.smr.domain.model;

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
public class StudentRegistration extends BaseDomain {
    private Long studentId;
    private String studentFirstName;
    private String studentLastName;
    private int studentDni;
    private String studentDniLastNameFirstName;

    private Long academicYearId;
    private int academicYearYear;

    private Long gradeLevelId;
    private int gradeLevelGradeNumber;

    private Long shiftId;
    private String shiftName;

    private Long sectionId;
    private String sectionName;

}
