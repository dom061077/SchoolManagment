package com.sms.smr.infra.outputadapter.jparepository.translation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sms.smr.domain.Translation;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.db.TranslationEntity;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepository;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@Component(value = "translationRepository")
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
        return (List<TranslationEntity>)queryRepository.getAllAnd(TranslationEntity.class, offset, limit, queryFilters, sortFilters);
    }

    @Override
    public long getCount(List<QueryDto> queryFilters) {
        return queryRepository.getCount(TranslationEntity.class, queryFilters);
    }

    @Override
    public Optional<TranslationEntity> update(Long id, TranslationEntity reg) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Optional<TranslationEntity> delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
