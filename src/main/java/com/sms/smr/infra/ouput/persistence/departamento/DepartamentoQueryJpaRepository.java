package com.sms.smr.infra.ouput.persistence.departamento;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.Departamento;
import com.sms.smr.infra.ouput.persistence.BaseSpecificationBuilder;
import com.sms.smr.infra.ouput.persistence.EntityMapper;
import com.sms.smr.infra.ouput.persistence.QueryBaseRepository;

@Repository
public class DepartamentoQueryJpaRepository extends QueryBaseRepository<Departamento, Long, DepartamentoEntity, DepartamentoJpaRepository> {
    public DepartamentoQueryJpaRepository(DepartamentoJpaRepository repository, EntityMapper<Departamento, DepartamentoEntity> mapper) {
        super(repository, new BaseSpecificationBuilder<DepartamentoEntity>(), mapper);
    }

}
