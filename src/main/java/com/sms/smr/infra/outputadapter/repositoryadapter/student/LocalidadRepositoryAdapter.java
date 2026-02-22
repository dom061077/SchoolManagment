package com.sms.smr.infra.outputadapter.repositoryadapter.student;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.Localidad;
import com.sms.smr.infra.outputadapter.db.LocalidadEntity;
import com.sms.smr.infra.outputadapter.jpa.BaseRepository;
import com.sms.smr.infra.outputadapter.jpa.repository.LocalidadJpaRepository;
import com.sms.smr.infra.outputadapter.jpa.repository.query.LocalidadQueryJpaRepository;
import com.sms.smr.infra.outputadapter.mapper.LocalidadEntityMapper;

@Repository
public class LocalidadRepositoryAdapter extends BaseRepository<Localidad, Long, LocalidadEntity, LocalidadJpaRepository>{
    public LocalidadRepositoryAdapter(LocalidadJpaRepository repository, LocalidadEntityMapper mapper) {
        super(repository, mapper, LocalidadEntity.class);
    }
}
