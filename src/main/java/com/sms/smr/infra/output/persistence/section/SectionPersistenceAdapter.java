package com.sms.smr.infra.output.persistence.section;

import java.util.Optional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sms.smr.domain.model.Section;
import com.sms.smr.infra.output.persistence.BaseRepository;

@Repository
public class SectionPersistenceAdapter
        extends BaseRepository<Section, Long, SectionEntity, SectionJpaRepository> {

    public SectionPersistenceAdapter(SectionJpaRepository repository, SectionEntityMapper mapper) {
        super(repository, mapper, SectionEntity.class);
    }

}