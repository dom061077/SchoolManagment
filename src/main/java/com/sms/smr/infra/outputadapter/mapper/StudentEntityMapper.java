package com.sms.smr.infra.outputadapter.mapper;

//https://manerajona.medium.com/mapping-bidirectional-object-associations-using-mapstruct-ce49b1857604

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.sms.smr.domain.Student;
import com.sms.smr.infra.outputadapter.db.StudentEntity;

@Mapper(
        componentModel = "spring"
)
 
public interface StudentEntityMapper extends EntityMapper<Student, StudentEntity> {

    @Override
    @Mapping(source = "localidadEntity.id", target = "localidadId")
    @Mapping(source = "localidadEntity.nombre", target = "localidadNombre")
    Student toDomain(StudentEntity entity);

    @Override
    @InheritInverseConfiguration
    @Mapping(target = "localidadEntity", ignore = true)
    StudentEntity toEntity(Student domain);

    @Override
    List<Student> getDomainList(List<StudentEntity> entities);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDomain(Student domain, @MappingTarget StudentEntity entity);

    
    
}
