package com.sms.smr.infra.ouput.persistence.student;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.sms.smr.domain.model.ParentescoTutor;
import com.sms.smr.infra.ouput.persistence.EntityMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ParentescoEnityMapper extends EntityMapper<ParentescoTutor, ParentescoTutorEntity> {

}
