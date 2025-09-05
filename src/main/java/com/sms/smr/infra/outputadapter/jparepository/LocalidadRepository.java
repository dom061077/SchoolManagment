package com.sms.smr.infra.outputadapter.jparepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.outputadapter.db.LocalidadEntity;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepository;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
//@Component(value = "localidadRepository")
public class LocalidadRepository implements EntityRepository<LocalidadEntity> {
    private final SpringDataRepository<LocalidadEntity> springDataRespository;
    private final QueryRepository<LocalidadEntity> queryRepository;

    @Override
    public LocalidadEntity save(LocalidadEntity reg) {
        return springDataRespository.save(reg);
    }

    @Override
    public Optional<LocalidadEntity> getById(Long id) {
        return springDataRespository.findById(id);
    }

    @Override
    public List<LocalidadEntity> getAll(int offset, int limit, List<QueryDto> queryFilters,
            List<QueryDto> sortFilters) {
        return queryRepository.getAllAnd(LocalidadEntity.class, offset, limit, queryFilters, sortFilters);
    }

    @Override
    public long getCount(List<QueryDto> queryFilters) {
        return queryRepository.getCount(LocalidadEntity.class, queryFilters);
    }

    @Override
    public Optional<LocalidadEntity> update(Long id, LocalidadEntity reg) {
        if (springDataRespository.existsById(id)) {
            reg.setId(id);
            return Optional.of(springDataRespository.save(reg));
        }   
        return Optional.empty();
    }

    @Override
    public Optional<LocalidadEntity> delete(Long id) {
        Optional<LocalidadEntity> localidadOptionalEntity = springDataRespository.findById(id);
        if (localidadOptionalEntity.isPresent()) {
            localidadOptionalEntity.get().setDeleted(true);
            springDataRespository.save(localidadOptionalEntity.get());
            
        } else {
            return Optional.empty();
        }
        
        return localidadOptionalEntity;
    }

}
