package com.sms.smr.infra.outputadapter.jparepository.student;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.Localidad;
import com.sms.smr.infra.outputadapter.db.LocalidadEntity;
import com.sms.smr.infra.outputadapter.jpa.BaseRepository;
import com.sms.smr.infra.outputadapter.jpa.repository.LocalidadJpaRepository;
import com.sms.smr.infra.outputadapter.jpa.repository.query.LocalidadQueryJpaRepository;
import com.sms.smr.infra.outputadapter.mapper.LocalidadEntityMapper;

@Repository
public class LocalidadRepositoryAdapter extends BaseRepository<Localidad, Long, LocalidadEntity, LocalidadJpaRepository, LocalidadQueryJpaRepository>{
    public LocalidadRepositoryAdapter(LocalidadJpaRepository repository, LocalidadEntityMapper mapper, LocalidadQueryJpaRepository queryRepository) {
        super(repository, mapper, queryRepository, LocalidadEntity.class);
    }
}
