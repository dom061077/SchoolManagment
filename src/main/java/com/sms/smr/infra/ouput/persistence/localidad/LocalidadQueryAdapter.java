package com.sms.smr.infra.ouput.persistence.localidad;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.Localidad;
import com.sms.smr.infra.ouput.persistence.QueryRepositoryBase;

@Repository
public class LocalidadQueryAdapter extends QueryRepositoryBase<Localidad, Long, LocalidadEntity, LocalidadJpaRepository> {
    public LocalidadQueryAdapter(LocalidadJpaRepository repository, LocalidadEntityMapper mapper) {
        super(repository, new com.sms.smr.infra.ouput.persistence.BaseSpecificationBuilder<LocalidadEntity>(), mapper);
    }


}
