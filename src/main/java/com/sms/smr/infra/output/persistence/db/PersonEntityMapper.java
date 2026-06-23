package com.sms.smr.infra.ouput.persistence.db;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.sms.smr.domain.model.Person;
import com.sms.smr.infra.ouput.persistence.EntityMapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonEntityMapper extends EntityMapper<Person, PersonEntity> {
}
