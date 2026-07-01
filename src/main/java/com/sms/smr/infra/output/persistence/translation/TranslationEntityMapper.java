package com.sms.smr.infra.output.persistence.translation;

import org.mapstruct.Mapper;

import com.sms.smr.domain.model.Translation;
import com.sms.smr.infra.output.persistence.EntityMapper;

@Mapper(componentModel = "spring")
public interface TranslationEntityMapper extends EntityMapper<Translation, TranslationEntity> {
}
