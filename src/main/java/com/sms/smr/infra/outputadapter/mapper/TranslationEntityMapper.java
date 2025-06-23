package com.sms.smr.infra.outputadapter.mapper;

import org.mapstruct.Mapper;

import com.sms.smr.domain.Translation;
import com.sms.smr.infra.outputadapter.db.TranslationEntity;

@Mapper(componentModel = "spring")
public interface TranslationEntityMapper {
    TranslationEntity toDbo(Translation translation);
    Translation toDomain(TranslationEntity translationEntity);
}
