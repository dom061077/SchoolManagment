package com.sms.smr.infra.ouput.persistence.provincia;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.Provincia;
import com.sms.smr.infra.ouput.persistence.BaseSpecificationBuilder;
import com.sms.smr.infra.ouput.persistence.EntityMapper;
import com.sms.smr.infra.ouput.persistence.QueryRepositoryBase;

@Repository
public class ProvinciaQueryJpaRepository extends QueryRepositoryBase<Provincia, Long,  ProvinciaEntity, ProvinciaJpaRepository> {
    public ProvinciaQueryJpaRepository(ProvinciaJpaRepository repository,EntityMapper<Provincia, ProvinciaEntity> mapper) {
        super(repository, new BaseSpecificationBuilder<ProvinciaEntity>(), mapper);
    }

}
