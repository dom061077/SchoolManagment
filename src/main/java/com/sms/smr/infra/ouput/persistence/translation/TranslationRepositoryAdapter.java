package com.sms.smr.infra.ouput.persistence.translation;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.Translation;
import com.sms.smr.infra.ouput.persistence.BaseRepository;

@Repository
public class TranslationRepositoryAdapter extends BaseRepository<Translation, Long, TranslationEntity, TranslationJpaRepository>{
    public TranslationRepositoryAdapter(TranslationJpaRepository repository, com.sms.smr.infra.outputadapter.mapper.TranslationEntityMapper mapper) {
        super(repository, mapper, TranslationEntity.class);
    }


}
