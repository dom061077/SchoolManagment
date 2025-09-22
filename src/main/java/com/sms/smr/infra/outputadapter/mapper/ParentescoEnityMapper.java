package com.sms.smr.infra.outputadapter.mapper;

import org.mapstruct.Mapper;

import com.sms.smr.domain.ParentescoTutor;
import com.sms.smr.infra.outputadapter.db.ParentescoTutorEntity;

@Mapper(componentModel = "spring")
public interface ParentescoEnityMapper extends EntityMapper<ParentescoTutor, ParentescoTutorEntity> {

}
