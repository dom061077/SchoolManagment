package com.sms.smr.infra.ouput.persistence.school;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.Shift;
import com.sms.smr.infra.ouput.persistence.BaseSpecificationBuilder;
import com.sms.smr.infra.ouput.persistence.EntityMapper;
import com.sms.smr.infra.ouput.persistence.QueryBaseRepository;

@Repository
public class ShiftQueryAdapter extends QueryBaseRepository<Shift, Long, ShiftEntity, ShiftJpaRepository> {

    public ShiftQueryAdapter(ShiftJpaRepository repository, EntityMapper<Shift, ShiftEntity> mapper) {
        super(repository, new BaseSpecificationBuilder<ShiftEntity>(), mapper);
    }
}
