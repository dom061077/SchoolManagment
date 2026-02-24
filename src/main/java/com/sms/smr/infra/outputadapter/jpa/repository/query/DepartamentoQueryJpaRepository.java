package com.sms.smr.infra.outputadapter.jpa.repository.query;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.Departamento;
import com.sms.smr.infra.outputadapter.db.DepartamentoEntity;
import com.sms.smr.infra.outputadapter.jpa.repository.DepartamentoJpaRepository;
import com.sms.smr.infra.outputadapter.mapper.EntityMapper;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.BaseSpecificationBuilder;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryRepositoryBase;

@Repository
public class DepartamentoQueryJpaRepository extends QueryRepositoryBase<Departamento, Long, DepartamentoEntity, DepartamentoJpaRepository> {
    public DepartamentoQueryJpaRepository(DepartamentoJpaRepository repository, EntityMapper<Departamento, DepartamentoEntity> mapper) {
        super(repository, new BaseSpecificationBuilder<DepartamentoEntity>(), mapper);
    }

}
