package com.sms.smr.infra.output.persistence.school;

import org.springframework.stereotype.Repository;

import com.sms.smr.domain.model.Shift;
import com.sms.smr.infra.output.persistence.BaseRepository;

@Repository
public class ShiftPersistenceAdapter extends BaseRepository<Shift, Long, ShiftEntity, ShiftJpaRepository> {

    public ShiftPersistenceAdapter(ShiftJpaRepository repository, ShiftEntityMapper mapper) {
        super(repository, mapper, ShiftEntity.class);
    }
}
