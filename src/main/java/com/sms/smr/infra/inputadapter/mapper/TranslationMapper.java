package com.sms.smr.infra.inputadapter.mapper;

import org.mapstruct.Mapper;

import com.sms.smr.domain.Translation;
import com.sms.smr.infra.inputadapter.dto.translation.TranslationDto;

@Mapper(componentModel = "spring")
public interface TranslationMapper {
    Translation toDomain(TranslationDto translationDto);
    TranslationDto toDto(Translation translation);
}
