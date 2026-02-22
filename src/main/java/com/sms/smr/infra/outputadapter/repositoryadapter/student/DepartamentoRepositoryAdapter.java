package com.sms.smr.infra.outputadapter.repositoryadapter.student;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.Departamento;
import com.sms.smr.infra.outputadapter.db.DepartamentoEntity;
import com.sms.smr.infra.outputadapter.jpa.BaseRepository;
import com.sms.smr.infra.outputadapter.jpa.repository.DepartamentoJpaRepository;
import com.sms.smr.infra.outputadapter.jpa.repository.query.DepartamentoQueryJpaRepository;
import com.sms.smr.infra.outputadapter.mapper.DepartamentoEntityMapper;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryRepository;

@Repository
public class DepartamentoRepositoryAdapter extends BaseRepository<Departamento, Long, DepartamentoEntity, DepartamentoJpaRepository>{
    public DepartamentoRepositoryAdapter(DepartamentoJpaRepository repository, DepartamentoEntityMapper mapper) {
        super(repository, mapper, DepartamentoEntity.class);
    }

}
