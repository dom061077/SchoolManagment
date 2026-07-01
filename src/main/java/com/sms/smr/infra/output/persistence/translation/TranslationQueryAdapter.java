package com.sms.smr.infra.output.persistence.translation;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.Translation;
import com.sms.smr.infra.output.persistence.BaseSpecificationBuilder;
import com.sms.smr.infra.output.persistence.EntityMapper;
import com.sms.smr.infra.output.persistence.QueryBaseRepository;

@Repository
public class TranslationQueryAdapter extends QueryBaseRepository<Translation, Long, TranslationEntity, TranslationJpaRepository> {

    public TranslationQueryAdapter(TranslationJpaRepository repository, EntityMapper<Translation, TranslationEntity> mapper) {
        super(repository,new BaseSpecificationBuilder<TranslationEntity>(), mapper);
        
    }

}
