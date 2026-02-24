package com.sms.smr.infra.outputadapter.repositoryadapter.translation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;

import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.db.TranslationEntity;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryRepository;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.AllArgsConstructor;



@AllArgsConstructor
//@Component(value = "translationRepository")
//Deprecated
public class TranslationRepository implements EntityRepository<TranslationEntity> {

    private final SpringDataTranslationRepository sDataTranslationRepository;
    private final QueryRepository queryRepository;

    @Override
    public TranslationEntity save(TranslationEntity reg) {
        return sDataTranslationRepository.save(reg);
    }

    @Override
    public Optional<TranslationEntity> getById(Long id) {
        return (Optional<TranslationEntity>) sDataTranslationRepository.findById(id);
    }

    @Override
    public List<TranslationEntity> getAll(int offset, int limit, List<QueryDto> queryFilters,
            List<QueryDto> sortFilters) {
        //return (List<TranslationEntity>)queryRepository.getAllAnd(TranslationEntity.class, offset, limit, queryFilters, sortFilters);
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public long getCount(List<QueryDto> queryFilters) {
        //return queryRepository.getCount(TranslationEntity.class, queryFilters);
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Optional<TranslationEntity> update(Long id, TranslationEntity reg) {
        Optional<TranslationEntity> translationOptionalEntity = sDataTranslationRepository.findById(id) ;
        if (translationOptionalEntity.isPresent()) {
            TranslationEntity entity = translationOptionalEntity.get();
            BeanUtils.copyProperties(reg, entity, "id");
            sDataTranslationRepository.save(entity);
            return Optional.of(entity);
        }
        return Optional.empty();
        
    }

    @Override
    public Optional<TranslationEntity> delete(Long id) {
        Optional<TranslationEntity> translationOptionalEntity = sDataTranslationRepository.findById(id);
        if (translationOptionalEntity.isPresent()) {
            translationOptionalEntity.get().setDeleted(true);
            sDataTranslationRepository.save(translationOptionalEntity.get());
            
        } else {
            return Optional.empty();
        }
        return translationOptionalEntity;
    }

}
