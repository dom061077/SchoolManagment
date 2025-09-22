package com.sms.smr.infra.outputadapter.mapper;

//https://manerajona.medium.com/mapping-bidirectional-object-associations-using-mapstruct-ce49b1857604

import org.mapstruct.Mapper;

import com.sms.smr.domain.Student;
import com.sms.smr.infra.outputadapter.db.StudentEntity;

@Mapper(
        componentModel = "spring", uses = {LocalidadEntityMapper.class, ParentescoEnityMapper.class} 
)
 
public interface StudentEntityMapper extends EntityMapper<Student, StudentEntity> {

    
    
}
