package com.sms.smr.infra.output.persistence.provincia;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.Provincia;
import com.sms.smr.infra.output.persistence.BaseSpecificationBuilder;
import com.sms.smr.infra.output.persistence.EntityMapper;
import com.sms.smr.infra.output.persistence.QueryBaseRepository;

@Repository
public class ProvinciaQueryAdapter extends QueryBaseRepository<Provincia, Long,  ProvinciaEntity, ProvinciaJpaRepository> {
    public ProvinciaQueryAdapter(ProvinciaJpaRepository repository,EntityMapper<Provincia, ProvinciaEntity> mapper) {
        super(repository, new BaseSpecificationBuilder<ProvinciaEntity>(), mapper);
    }

}
