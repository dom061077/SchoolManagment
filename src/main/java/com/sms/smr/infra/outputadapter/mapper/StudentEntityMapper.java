package com.sms.smr.infra.outputadapter.mapper;

//https://manerajona.medium.com/mapping-bidirectional-object-associations-using-mapstruct-ce49b1857604

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sms.smr.domain.Student;
import com.sms.smr.infra.outputadapter.db.StudentEntity;

@Mapper(
        componentModel = "spring"
)
 
public interface StudentEntityMapper extends GenericMapper<StudentEntity, Student> {

    @Override
    @Mapping(source = "localidadEntity.id", target = "localidadId")
    @Mapping(source = "localidadEntity.nombre", target = "localidadNombre")
    Student toDomain(StudentEntity entity);

    @Override
    @InheritInverseConfiguration
    @Mapping(target = "localidadEntity", ignore = true)
    StudentEntity toEntity(Student domain);
    
}
