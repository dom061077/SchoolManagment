package com.sms.smr.infra.ouput.persistence.departamento;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.Departamento;
import com.sms.smr.domain.ports.out.QueryRepository;
import com.sms.smr.infra.ouput.persistence.BaseRepository;

@Repository
public class DepartamentoRepositoryAdapter extends BaseRepository<Departamento, Long, DepartamentoEntity, DepartamentoJpaRepository>{
    public DepartamentoRepositoryAdapter(DepartamentoJpaRepository repository, DepartamentoEntityMapper mapper) {
        super(repository, mapper, DepartamentoEntity.class);
    }

}
