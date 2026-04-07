package com.sms.smr.infra.ouput.persistence.localidad;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.Localidad;
import com.sms.smr.infra.ouput.persistence.BaseSpecificationBuilder;
import com.sms.smr.infra.ouput.persistence.QueryBaseRepository;

@Repository
public class LocalidadQueryAdapter extends QueryBaseRepository<Localidad, Long, LocalidadEntity, LocalidadJpaRepository> {
    public LocalidadQueryAdapter(LocalidadJpaRepository repository, LocalidadEntityMapper mapper) {
        super(repository, new BaseSpecificationBuilder<LocalidadEntity>(), mapper);
    }


}
