package com.sms.smr.infra.output.persistence.localidad;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.Localidad;
import com.sms.smr.infra.output.persistence.BaseSpecificationBuilder;
import com.sms.smr.infra.output.persistence.QueryBaseRepository;

@Repository
public class LocalidadQueryAdapter extends QueryBaseRepository<Localidad, Long, LocalidadEntity, LocalidadJpaRepository> {
    public LocalidadQueryAdapter(LocalidadJpaRepository repository, LocalidadEntityMapper mapper) {
        super(repository, new BaseSpecificationBuilder<LocalidadEntity>(), mapper);
    }


}
