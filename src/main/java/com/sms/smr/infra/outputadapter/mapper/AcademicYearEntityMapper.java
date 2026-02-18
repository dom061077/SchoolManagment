package com.sms.smr.infra.outputadapter.mapper;

import org.mapstruct.Mapper;

import com.sms.smr.domain.AcademicYear;
import com.sms.smr.infra.outputadapter.db.academic.AcademicYearEntity;

@Mapper(
    componentModel = "spring"
)
public interface AcademicYearEntityMapper extends EntityMapper<AcademicYear,AcademicYearEntity>{

}
