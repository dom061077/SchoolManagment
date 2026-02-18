package com.sms.smr.infra.outputadapter.jpa.repository.query;

import org.springframework.stereotype.Repository;

import com.sms.smr.infra.outputadapter.db.DepartamentoEntity;
import com.sms.smr.infra.outputadapter.jpa.repository.DepartamentoJpaRepository;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.BaseSpecificationBuilder;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepositoryBase;

@Repository
public class DepartamentoQueryJpaRepository extends QueryRepositoryBase<DepartamentoEntity, Long, DepartamentoJpaRepository> {
    public DepartamentoQueryJpaRepository(DepartamentoJpaRepository repository) {
        super(repository, new BaseSpecificationBuilder<DepartamentoEntity>());
    }

}
