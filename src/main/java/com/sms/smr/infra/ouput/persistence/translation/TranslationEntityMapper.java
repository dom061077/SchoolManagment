package com.sms.smr.infra.ouput.persistence.translation;

import org.mapstruct.Mapper;

import com.sms.smr.domain.model.Translation;
import com.sms.smr.infra.ouput.persistence.EntityMapper;

@Mapper(componentModel = "spring")
public interface TranslationEntityMapper extends EntityMapper<Translation, TranslationEntity> {
}
