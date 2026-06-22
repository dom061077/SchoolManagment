package com.sms.smr.infra.ouput.persistence.departamento;

import com.sms.smr.domain.model.Departamento;
import com.sms.smr.infra.ouput.persistence.BaseSpecificationBuilder;
import com.sms.smr.infra.ouput.persistence.QueryBaseRepository;

public class DepartamentoQueryAdapter extends QueryBaseRepository<Departamento, Long, DepartamentoEntity, DepartamentoJpaRepository> {
    public DepartamentoQueryAdapter(DepartamentoJpaRepository repository, DepartamentoEntityMapper mapper) {
        super(repository, new BaseSpecificationBuilder<DepartamentoEntity>(), mapper);
    }

}
