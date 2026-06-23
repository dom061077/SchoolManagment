package com.sms.smr.infra.ouput.persistence.schoolexam;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sms.smr.domain.model.academic.SchoolExam;
import com.sms.smr.infra.ouput.persistence.BaseRepository;
import com.sms.smr.infra.ouput.persistence.CycleAvoidingMappingContext;
import com.sms.smr.infra.ouput.persistence.academic.SchoolExamEntity;

@Repository
public class SchoolExamPersistenceAdapter extends BaseRepository<SchoolExam, Long, SchoolExamEntity, SchoolExamJpaRepository> {
    public SchoolExamPersistenceAdapter(SchoolExamJpaRepository repository, SchoolExamMapper mapper) {
        super(repository, mapper, SchoolExamEntity.class);
    }

    @Override
    @Transactional
    public Optional<SchoolExam> update(Long id, SchoolExam reg) {
        return repository.findById(id).map(entity -> {
            if (entity.getDetails() != null) {
                entity.getDetails().clear();
            }
            repository.saveAndFlush(entity); // Flush deletion of orphans immediately to avoid constraint issues
            mapper.updateEntityFromDomain(reg, entity, new CycleAvoidingMappingContext());
            SchoolExamEntity saved = repository.save(entity);
            return mapper.toDomain(saved, new CycleAvoidingMappingContext());
        });
    }
}
