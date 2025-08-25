package com.sms.smr.infra.inputadapter;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.smr.domain.Student;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.inputadapter.dto.student.StudentDto;
import com.sms.smr.infra.inputadapter.dto.student.StudentDtoAfterPost;
import com.sms.smr.infra.inputadapter.mapper.StudentMapper;
import com.sms.smr.infra.inputadapter.utils.Utils;
import com.sms.smr.infra.inputport.BaseInputPort;
import com.sms.smr.infra.inputport.StudentInputPort;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
//https://manerajona.medium.com/mapping-bidirectional-object-associations-using-mapstruct-ce49b1857604
//https://www.toptal.com/spring/spring-boot-oauth2-jwt-rest-protection
@RestController
@RequestMapping(value = "/api/v1/alumno")
@RequiredArgsConstructor
public class StudentApi {
    
    @Qualifier(value = "studentUseCase")
    private final BaseInputPort<Student> baseInputPort;
    
    private final  StudentMapper studentMapper;
    private static final Logger logger = LoggerFactory.getLogger(StudentApi.class);

    @PostMapping(value = "create", produces=MediaType.APPLICATION_JSON_VALUE)
    public StudentDtoAfterPost create( @RequestBody @Valid StudentDto alumnoDto ) {
        logger.info("DTO recibido: "+alumnoDto.getApellido());
        return studentMapper.studentToStudentDtoAfterPost(studentInputPort.create (studentMapper.studentPostDtoToStudent(alumnoDto)));
    }

    @GetMapping(value = "/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public StudentDto getAlumno(@PathVariable("id") Long id) {
        logger.info("ID de alumno a buscar: "+id);
        return studentMapper.studentToStudentDto(studentInputPort.getById(id));
    }

    @GetMapping(value = "/list", produces =MediaType.APPLICATION_JSON_VALUE)
    public  QueryResult<Student> getAll( @RequestParam int offset,@RequestParam  int limit
        ,@RequestParam String qfilters, @RequestParam String sorts) {
        logger.info("Filters: "+qfilters);
        List<QueryDto> queryFilters = Utils.stringToQueryFilterDto(qfilters);
        queryFilters.add(QueryDto.builder().property("deleted:eq").value("false").build());

        List<QueryDto> sortFilters = Utils.stringToQueryFilterDto(sorts); 
        return studentInputPort.getAll(offset, limit, queryFilters,sortFilters);      
    }
}
