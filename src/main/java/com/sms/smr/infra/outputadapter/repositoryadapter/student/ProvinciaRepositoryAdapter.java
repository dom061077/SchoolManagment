package com.sms.smr.infra.outputadapter.repositoryadapter.student;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.Provincia;
import com.sms.smr.infra.outputadapter.db.ProvinciaEntity;
import com.sms.smr.infra.outputadapter.jpa.BaseRepository;
import com.sms.smr.infra.outputadapter.jpa.repository.ProvinciaJpaRepository;
import com.sms.smr.infra.outputadapter.jpa.repository.query.ProvinciaQueryJpaRepository;
import com.sms.smr.infra.outputadapter.mapper.ProvinciaEntityMapper;

@Repository
public class ProvinciaRepositoryAdapter extends BaseRepository<Provincia, Long, ProvinciaEntity, ProvinciaJpaRepository>{
    public ProvinciaRepositoryAdapter(ProvinciaJpaRepository repository, ProvinciaEntityMapper mapper) {
        super(repository, mapper, ProvinciaEntity.class);
    }           

}
