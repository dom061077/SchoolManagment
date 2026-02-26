package com.sms.smr.infra.ouput.persistence.student;

//https://manerajona.medium.com/mapping-bidirectional-object-associations-using-mapstruct-ce49b1857604

import org.mapstruct.Mapper;

import com.sms.smr.domain.model.Student;
import com.sms.smr.infra.ouput.persistence.EntityMapper;
import com.sms.smr.infra.ouput.persistence.localidad.LocalidadEntityMapper;

@Mapper(
        componentModel = "spring", uses = {LocalidadEntityMapper.class, ParentescoEnityMapper.class} 
)
 
public interface StudentEntityMapper extends EntityMapper<Student, StudentEntity> {

    
    
}
