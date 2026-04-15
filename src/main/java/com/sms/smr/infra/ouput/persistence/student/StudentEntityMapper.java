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

    @Override
    @Mapping(target = "localidadId", source = "localidad.id")
    @Mapping(target = "parentescoTutorId", source = "parentescoTutor.id")
    @Mapping(target = "parentescoTutorDescripcion", source = "parentescoTutor.descripcion")
    @Mapping
    Student toDomain(StudentEntity entity, @Context CycleAvoidingMappingContext context);

    @Override
    StudentEntity toEntity(Student domain, @Context CycleAvoidingMappingContext context);
    
}
