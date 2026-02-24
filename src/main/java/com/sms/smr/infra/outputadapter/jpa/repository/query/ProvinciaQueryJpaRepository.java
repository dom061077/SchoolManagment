package com.sms.smr.infra.outputadapter.jpa.repository.query;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.Provincia;
import com.sms.smr.infra.outputadapter.db.ProvinciaEntity;
import com.sms.smr.infra.outputadapter.jpa.repository.ProvinciaJpaRepository;
import com.sms.smr.infra.outputadapter.mapper.EntityMapper;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.BaseSpecificationBuilder;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryRepositoryBase;

@Repository
public class ProvinciaQueryJpaRepository extends QueryRepositoryBase<Provincia, Long,  ProvinciaEntity, ProvinciaJpaRepository> {
    public ProvinciaQueryJpaRepository(ProvinciaJpaRepository repository,EntityMapper<Provincia, ProvinciaEntity> mapper) {
        super(repository, new BaseSpecificationBuilder<ProvinciaEntity>(), mapper);
    }

}
