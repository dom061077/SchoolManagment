package com.sms.smr.application;

import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.sms.smr.domain.Translation;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.inputport.BaseInputPort;
import com.sms.smr.infra.outputadapter.db.TranslationEntity;
import com.sms.smr.infra.outputadapter.mapper.CycleAvoidingMappingContext;
import com.sms.smr.infra.outputadapter.mapper.TranslationEntityMapper;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryResult;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


//@Component(value = "translationUseCase")
@AllArgsConstructor
public class TranslationUseCase implements BaseInputPort<Translation, Long> {

    private static final Logger logger = LoggerFactory.getLogger(TranslationUseCase.class);
    
    @Qualifier(value = "translationRepository")
    private final EntityRepository<TranslationEntity> entityRepository;
    private final TranslationEntityMapper translationEntityMapper;

    // Lombok's @RequiredArgsConstructor generates the required constructor

    @Override
    public Translation create(Translation translation) {
        return translationEntityMapper.toDomain(entityRepository.save(translationEntityMapper.toEntity(translation, new CycleAvoidingMappingContext())), new CycleAvoidingMappingContext());
    }

    @Override
    public Optional<Translation> getById(Long id) {
        return entityRepository.getById(id).map(translationEntity -> translationEntityMapper.toDomain(translationEntity, new CycleAvoidingMappingContext()) );
    }

    @Override
    public QueryResult<Translation> getAll(int offset, int limit, List<QueryDto> queryFilters,
            List<QueryDto> sorts) {
        QueryResult<Translation> qResult = new QueryResult<Translation>();
        qResult.setData(translationEntityMapper.getDomainList(entityRepository.getAll(offset, limit, queryFilters, sorts), new CycleAvoidingMappingContext()));
        long count = entityRepository.getCount(queryFilters);
        qResult.setTotal(count);
        
        return qResult;
    }

    @Override
    public Translation update(Long id, Translation entity) {
        //return entityRepository.update(id, translationEntityMapper.toEntity(entity, new CycleAvoidingMappingContext()))
        //        .map(translationEntity -> translationEntityMapper.toDomain(translationEntity, new CycleAvoidingMappingContext()));
                //.map(translationEntityMapper::toDomain);
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(Long id) {
        Optional<TranslationEntity> deletedTranslation = entityRepository.delete(id);
        if(deletedTranslation.isPresent())
            return false;
        return true;
    }

    @Override
    public Page<Translation> getAll(int offset, int limit, String queryFilters, String sortings,
            String loperator) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }



}
