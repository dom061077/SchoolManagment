package com.sms.smr.infra.output.persistence.translation;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.Translation;
import com.sms.smr.infra.output.persistence.BaseRepository;

@Repository
public class TranslationRepositoryAdapter extends BaseRepository<Translation, Long, TranslationEntity, TranslationJpaRepository>{
    public TranslationRepositoryAdapter(TranslationJpaRepository repository, com.sms.smr.infra.output.persistence.translation.TranslationEntityMapper mapper) {
        super(repository, mapper, TranslationEntity.class);
    }


}
