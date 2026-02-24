package com.sms.smr.infra.outputadapter.jpa.repository.query;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.Localidad;
import com.sms.smr.infra.outputadapter.db.LocalidadEntity;
import com.sms.smr.infra.outputadapter.jpa.repository.LocalidadJpaRepository;
import com.sms.smr.infra.outputadapter.mapper.EntityMapper;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.BaseSpecificationBuilder;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryRepositoryBase;

@Repository
public class LocalidadQueryJpaRepository extends QueryRepositoryBase<Localidad, Long, LocalidadEntity, LocalidadJpaRepository> {
    public LocalidadQueryJpaRepository(LocalidadJpaRepository repository, EntityMapper<Localidad,LocalidadEntity> mapper) {
        super(repository, new BaseSpecificationBuilder<LocalidadEntity>(), mapper);
    }

}
