package com.sms.smr.application;

import java.util.List;
import java.util.Optional;

import org.mapstruct.Qualifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.sms.smr.domain.Translation;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.inputport.BaseInputPort;
import com.sms.smr.infra.outputadapter.db.TranslationEntity;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;
import com.sms.smr.infra.outputadapter.mapper.TranslationEntityMapper;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;

@Component(value = "translationUseCase")
@RequiredArgsConstructor
public class TranslationUseCase implements BaseInputPort<Translation> {

    private static final Logger logger = LoggerFactory.getLogger(TranslationUseCase.class);
    
    private final EntityRepository<TranslationEntity> entityRepository;
    private final TranslationEntityMapper translationEntityMapper;

    // Lombok's @RequiredArgsConstructor generates the required constructor

    @Override
    public Translation create(Translation translation) {
        return translationEntityMapper.toDomain(entityRepository.save(translationEntityMapper.toDbo(translation)));
    }

    @Override
    public Optional<Translation> getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public QueryResult<Translation> getAll(int offset, int limit, List<QueryDto> queryFilters,
            List<QueryDto> sortings) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Optional<Translation> update(Long id, Translation entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    // Implement other methods as needed...

}
