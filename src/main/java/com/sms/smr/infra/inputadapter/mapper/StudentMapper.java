package com.sms.smr.infra.inputadapter.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.sms.smr.infra.inputadapter.dto.student.StudentDto;
import com.sms.smr.infra.inputadapter.dto.student.StudentDtoAfterPost;
import com.sms.smr.domain.Student;

@Mapper(
        componentModel = "spring"
)
public interface StudentMapper {

        StudentDto studentToStudentDto(Student student);

        Student studentPostDtoToStudent(StudentDto studenDtoPost);

        StudentDtoAfterPost studentToStudentDtoAfterPost(Student student);

        List<StudentDto> getStudentDtos(List<Student> students);
    
}
