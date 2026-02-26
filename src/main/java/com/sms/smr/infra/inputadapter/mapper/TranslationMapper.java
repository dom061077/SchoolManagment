package com.sms.smr.infra.inputadapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.sms.smr.domain.model.Translation;
import com.sms.smr.infra.ouput.persistence.EntityMapper;
import com.sms.smr.infra.ouput.persistence.translation.TranslationEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TranslationMapper extends EntityMapper<Translation, TranslationEntity> {
/*
    TranslationMapper INSTANCE = Mappers.getMapper(TranslationMapper.class);

    @Override
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    TranslationEntity toEntity(Translation domain);

    @Override
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    Translation toDomain(TranslationEntity entity);

    @Override
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "lastModifiedBy", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    void updateEntityFromDomain(Translation domain, @MappingTarget TranslationEntity entity);
    */
}
