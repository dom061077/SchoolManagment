package com.sms.smr.application;

import org.mapstruct.Qualifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sms.smr.domain.Translation;
import com.sms.smr.infra.inputport.BaseInputPort;
import com.sms.smr.infra.outputadapter.db.TranslationEntity;
import com.sms.smr.infra.outputadapter.mapper.TranslationEntityMapper;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;

@Component(value = "translationUseCase")
@RequiredArgsConstructor
public class TranslationUseCase implements BaseInputPort<Translation> {

    private static final Logger logger = LoggerFactory.getLogger(TranslationUseCase.class);
    
    @Qualifier(value="translationRepository")
    private final EntityRepository<TranslationEntity> entityRepository;
    private final TranslationEntityMapper translationEntityMapper;

    // Lombok's @RequiredArgsConstructor generates the required constructor

    @Override
    public Translation create(Translation translation) {
        return translationEntityMapper.toDomain(entityRepository.save(translationEntityMapper.toDbo(translation)));
    }

    // Implement other methods as needed...

}
