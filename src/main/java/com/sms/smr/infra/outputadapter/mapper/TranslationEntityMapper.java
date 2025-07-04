package com.sms.smr.infra.outputadapter.mapper;

import org.mapstruct.Mapper;

import com.sms.smr.domain.Translation;
import com.sms.smr.infra.outputadapter.db.TranslationEntity;
import java.util.List;

@Mapper(componentModel = "spring")
public interface TranslationEntityMapper {
    TranslationEntity toDbo(Translation translation);
    Translation toDomain(TranslationEntity translationEntity);
    
    List<Translation> getTranslations(List<TranslationEntity> translations);
}
