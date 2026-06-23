package com.sms.smr.infra.ouput.persistence.localidad;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.Localidad;
import com.sms.smr.infra.ouput.persistence.BaseSpecificationBuilder;
import com.sms.smr.infra.ouput.persistence.EntityMapper;
import com.sms.smr.infra.ouput.persistence.QueryBaseRepository;

@Repository
public class LocalidadQueryJpaRepository extends QueryBaseRepository<Localidad, Long, LocalidadEntity, LocalidadJpaRepository> {
    public LocalidadQueryJpaRepository(LocalidadJpaRepository repository, EntityMapper<Localidad,LocalidadEntity> mapper) {
        super(repository, new BaseSpecificationBuilder<LocalidadEntity>(), mapper);
    }

}
