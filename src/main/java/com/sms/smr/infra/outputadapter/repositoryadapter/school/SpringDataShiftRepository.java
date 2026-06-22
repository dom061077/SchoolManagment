package com.sms.smr.infra.outputadapter.repositoryadapter.school;

import org.springframework.stereotype.Component;

import com.sms.smr.domain.model.Shift;
import com.sms.smr.infra.ouput.persistence.BaseRepository;
import com.sms.smr.infra.ouput.persistence.EntityMapper;
import com.sms.smr.infra.ouput.persistence.school.ShiftEntity;
import com.sms.smr.infra.ouput.persistence.school.ShiftJpaRepository;

@Component
public class SpringDataShiftRepository extends BaseRepository<Shift, Long, ShiftEntity, ShiftJpaRepository> {

    public SpringDataShiftRepository(ShiftJpaRepository repository, EntityMapper<Shift, ShiftEntity> mapper) {
        super(repository, mapper, ShiftEntity.class);
    }
}
