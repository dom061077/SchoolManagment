package com.sms.smr.infra.output.persistence.departamento;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.Departamento;
import com.sms.smr.infra.output.persistence.BaseRepository;

@Repository
public class DepartamentoRepositoryAdapter
        extends BaseRepository<Departamento, Long, DepartamentoEntity, DepartamentoJpaRepository> {
    public DepartamentoRepositoryAdapter(DepartamentoJpaRepository repository, DepartamentoEntityMapper mapper) {
        super(repository, mapper, DepartamentoEntity.class);
    }

}
