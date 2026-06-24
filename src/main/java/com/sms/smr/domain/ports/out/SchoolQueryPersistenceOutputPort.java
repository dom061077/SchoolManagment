package com.sms.smr.domain.ports.out;

import java.util.Optional;
import com.sms.smr.domain.model.School;

public interface SchoolQueryPersistenceOutputPort extends QueryPersistenceOutputPort<School, Long> {
    Optional<School> findByCue(String cue);
}
