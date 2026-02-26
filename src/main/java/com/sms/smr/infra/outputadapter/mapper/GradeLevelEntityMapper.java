package com.sms.smr.infra.outputadapter.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import com.lowagie.text.Section;
import com.sms.smr.domain.model.GradeLevel;
import com.sms.smr.infra.ouput.persistence.db.school.GradeLevelEntity;

@Component
public class GradeLevelEntityMapper implements BaseEntityMapper<GradeLevel, GradeLevelEntity> {

    @Override
    public GradeLevel toDomain(GradeLevelEntity entity) {
        if (entity == null) return null;
        return GradeLevel.builder()
                .id(entity.getId())
                .gradeNumber(entity.getGradeNumber())
                .build();
     }

    @Override
    public GradeLevelEntity toEntity(GradeLevel domain) {
        if(domain == null) return null;
        return GradeLevelEntity.builder()
                .id(domain.getId())
                .gradeNumber(domain.getGradeNumber())
                .build();
    }

        

    
 
}
