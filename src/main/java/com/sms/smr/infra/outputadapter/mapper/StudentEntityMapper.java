package com.sms.smr.infra.outputadapter.mapper;

//https://manerajona.medium.com/mapping-bidirectional-object-associations-using-mapstruct-ce49b1857604

import java.util.List;

import org.mapstruct.Mapper;

import com.sms.smr.domain.Student;
import com.sms.smr.infra.outputadapter.db.StudentEntity;

@Mapper(
        componentModel = "spring"
)
 
public interface StudentEntityMapper { 

    Student toDomain(StudentEntity studentEntity);

    StudentEntity toDbo(Student student);

    List <Student> getStudents(List<StudentEntity> studentEntities);
    
}
