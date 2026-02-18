package com.sms.smr.infra.outputadapter.jparepository.student;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.Departamento;
import com.sms.smr.infra.outputadapter.db.DepartamentoEntity;
import com.sms.smr.infra.outputadapter.jpa.BaseRepository;
import com.sms.smr.infra.outputadapter.jpa.repository.DepartamentoJpaRepository;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepositoryImpl;
import com.sms.smr.infra.outputadapter.mapper.DepartamentoEntityMapper;

@Repository
public class DepartamentoRepositoryAdapter extends BaseRepository<Departamento, Long, DepartamentoEntity, DepartamentoJpaRepository, QueryRepositoryImpl<DepartamentoEntity>>{
    public DepartamentoRepositoryAdapter(DepartamentoJpaRepository repository, DepartamentoEntityMapper mapper, QueryRepositoryImpl<DepartamentoEntity> queryRepository) {
        super(repository, mapper, queryRepository, DepartamentoEntity.class);
    }

}
