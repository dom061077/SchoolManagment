package com.sms.smr.infra.ouput.persistence.student;

//https://manerajona.medium.com/mapping-bidirectional-object-associations-using-mapstruct-ce49b1857604

import org.mapstruct.Mapper;

import com.sms.smr.domain.model.Student;
import com.sms.smr.infra.ouput.persistence.EntityMapper;
import com.sms.smr.infra.ouput.persistence.CycleAvoidingMappingContext;
import org.mapstruct.Mapping;
import org.mapstruct.Context;
import org.mapstruct.MappingTarget;

@Mapper( 
        componentModel = "spring",
        uses = StudentReferenceMapper.class
)
 
public interface StudentEntityMapper extends EntityMapper<Student, StudentEntity> {

    @Override
    @Mapping(target = "localidadId", source = "localidadEntity.id")
    @Mapping(target = "localidadNombre", source = "localidadEntity.nombre")
    @Mapping(target = "departamentoId", source = "localidadEntity.departamento.id")
    @Mapping(target = "departamentoNombre", source = "localidadEntity.departamento.nombre")
    @Mapping(target = "provinciaId", source = "localidadEntity.departamento.provincia.id")
    @Mapping(target = "provinciaNombre", source = "localidadEntity.departamento.provincia.nombre")
    @Mapping(target = "localidadEntity", ignore = true)
    @Mapping(target = "parentescoTutorId", source = "parentescoTutorEntity.id")
    @Mapping(target = "parentescoTutorDescripcion", source = "parentescoTutorEntity.descripcion")
    @Mapping(target = "dni", source = "dni")
    Student toDomain(StudentEntity entity, @Context CycleAvoidingMappingContext context);

    @Override
    @Mapping(target = "localidadEntity", source = "localidadId")
    @Mapping(target = "parentescoTutorEntity", source = "parentescoTutorId")
    StudentEntity toEntity(Student domain, @Context CycleAvoidingMappingContext context);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "localidadEntity", source = "localidadId")
    @Mapping(target = "parentescoTutorEntity", source = "parentescoTutorId")
    @Mapping(target = "dni", source = "dni")
    void updateEntityFromDomain(Student domain, @MappingTarget StudentEntity entity, @Context CycleAvoidingMappingContext context);
    
}
