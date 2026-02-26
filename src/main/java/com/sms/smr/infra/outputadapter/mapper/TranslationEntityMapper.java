package com.sms.smr.infra.outputadapter.mapper;

import org.mapstruct.Mapper;

import com.sms.smr.domain.model.Translation;
import com.sms.smr.infra.ouput.persistence.EntityMapper;
import com.sms.smr.infra.ouput.persistence.translation.TranslationEntity;

@Mapper(componentModel = "spring")
public interface TranslationEntityMapper extends EntityMapper<Translation, TranslationEntity> {
}
