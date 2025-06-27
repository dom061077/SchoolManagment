package com.sms.smr.infra.outputadapter.jparepository.translation;

import java.util.List;
import java.util.Optional;

import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.db.TranslationEntity;
import com.sms.smr.infra.outputport.EntityRepository;

public class TranslationRepository implements EntityRepository<TranslationEntity> {

    static final SpringDataTranslationRepository sDataTranslationRepository = null;

    @Override
    public TranslationEntity save(TranslationEntity reg) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<TranslationEntity> getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public List<TranslationEntity> getAll(int offset, int limit, List<QueryDto> queryFilters,
            List<QueryDto> sortFilters) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public long getCount(List<QueryDto> queryFilters) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCount'");
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
