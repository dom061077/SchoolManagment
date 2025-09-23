package com.sms.smr.infra.outputadapter.mapper;

import org.mapstruct.Mapper;

import com.sms.smr.domain.Departamento;
import com.sms.smr.infra.outputadapter.db.DepartamentoEntity;

@Mapper(componentModel="spring", uses={ProvinciaEntityMapper.class})
public interface DepartamentoEntityMapper extends EntityMapper<Departamento,DepartamentoEntity> {

}
