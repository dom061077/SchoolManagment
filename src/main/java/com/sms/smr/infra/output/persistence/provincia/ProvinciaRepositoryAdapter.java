package com.sms.smr.infra.output.persistence.provincia;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.Provincia;
import com.sms.smr.infra.output.persistence.BaseRepository;

@Repository
public class ProvinciaRepositoryAdapter extends BaseRepository<Provincia, Long, ProvinciaEntity, ProvinciaJpaRepository>{
    public ProvinciaRepositoryAdapter(ProvinciaJpaRepository repository, ProvinciaEntityMapper mapper) {
        super(repository, mapper, ProvinciaEntity.class);
    }           

}
