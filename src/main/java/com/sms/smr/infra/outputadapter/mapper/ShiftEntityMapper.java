package com.sms.smr.infra.outputadapter.mapper;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.springframework.stereotype.Component;

import com.sms.smr.domain.model.Shift;
import com.sms.smr.infra.ouput.persistence.db.school.ShiftEntity;

@Component
public class ShiftEntityMapper implements BaseEntityMapper<Shift, ShiftEntity> {

    @Override
    public Shift toDomain(ShiftEntity entity) {
        if (entity == null) return null;
        return Shift.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
     }

    @Override
    public ShiftEntity toEntity(Shift domain) {
        if(domain == null) return null;
        return ShiftEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .build();
    }


}
