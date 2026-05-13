package com.sms.smr.infra.ouput.persistence.section;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sms.smr.domain.model.Section;
import com.sms.smr.infra.ouput.persistence.BaseRepository;

@Repository
public class SectionPersistenceAdapter
        extends BaseRepository<Section, Long, SectionEntity, SectionJpaRepository> {

    public SectionPersistenceAdapter(SectionJpaRepository repository, SectionEntityMapper mapper) {
        super(repository, mapper, SectionEntity.class);
    }

}