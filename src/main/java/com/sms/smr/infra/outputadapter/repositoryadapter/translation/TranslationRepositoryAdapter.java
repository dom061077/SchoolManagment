package com.sms.smr.infra.outputadapter.repositoryadapter.translation;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.Translation;
import com.sms.smr.infra.outputadapter.db.TranslationEntity;
import com.sms.smr.infra.outputadapter.jpa.BaseRepository;
import com.sms.smr.infra.outputadapter.jpa.repository.TranslationJpaRepository;

@Repository
public class TranslationRepositoryAdapter extends BaseRepository<Translation, Long, TranslationEntity, TranslationJpaRepository>{
    public TranslationRepositoryAdapter(TranslationJpaRepository repository, com.sms.smr.infra.outputadapter.mapper.TranslationEntityMapper mapper) {
        super(repository, mapper, TranslationEntity.class);
    }


}
