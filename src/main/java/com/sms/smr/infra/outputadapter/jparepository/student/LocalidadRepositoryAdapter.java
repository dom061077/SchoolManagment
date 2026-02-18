package com.sms.smr.infra.outputadapter.jparepository.student;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.Localidad;
import com.sms.smr.infra.outputadapter.db.LocalidadEntity;
import com.sms.smr.infra.outputadapter.jpa.BaseRepository;
import com.sms.smr.infra.outputadapter.jpa.repository.LocalidadJpaRepository;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepositoryImpl;
import com.sms.smr.infra.outputadapter.mapper.LocalidadEntityMapper;

@Repository
public class LocalidadRepositoryAdapter extends BaseRepository<Localidad, Long, LocalidadEntity, LocalidadJpaRepository, QueryRepositoryImpl<LocalidadEntity>>{
    public LocalidadRepositoryAdapter(LocalidadJpaRepository repository, LocalidadEntityMapper mapper, QueryRepositoryImpl<LocalidadEntity> queryRepository) {
        super(repository, mapper, queryRepository, LocalidadEntity.class);
    }
}
