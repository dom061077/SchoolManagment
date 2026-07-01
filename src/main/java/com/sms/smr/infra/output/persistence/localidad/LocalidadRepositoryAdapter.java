package com.sms.smr.infra.output.persistence.localidad;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.Localidad;
import com.sms.smr.infra.output.persistence.BaseRepository;

@Repository
public class LocalidadRepositoryAdapter extends BaseRepository<Localidad, Long, LocalidadEntity, LocalidadJpaRepository>{
    public LocalidadRepositoryAdapter(LocalidadJpaRepository repository, LocalidadEntityMapper mapper) {
        super(repository, mapper, LocalidadEntity.class);
    }
}
