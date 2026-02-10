package com.sms.smr.infra.outputadapter.jparepository.student;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.Provincia;
import com.sms.smr.infra.outputadapter.db.ProvinciaEntity;
import com.sms.smr.infra.outputadapter.jpa.BaseRepository;
import com.sms.smr.infra.outputadapter.jpa.repository.ProvinciaJpaRepository;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepositoryImpl;
import com.sms.smr.infra.outputadapter.mapper.ProvinciaEntityMapper;

@Repository
public class ProvinciaRepositoryAdapter extends BaseRepository<Provincia, Long, ProvinciaEntity, ProvinciaJpaRepository, QueryRepositoryImpl<ProvinciaEntity>>{
    public ProvinciaRepositoryAdapter(ProvinciaJpaRepository repository, ProvinciaEntityMapper mapper, QueryRepositoryImpl<ProvinciaEntity> queryRepository) {
        super(repository, mapper, queryRepository, ProvinciaEntity.class);
    }           

}
