package com.sms.smr.infra.inputadapter;

import com.sms.smr.domain.Student;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.inputadapter.utils.Utils;
import com.sms.smr.infra.inputport.StudentInputPort;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//https://manerajona.medium.com/mapping-bidirectional-object-associations-using-mapstruct-ce49b1857604
//https://www.toptal.com/spring/spring-boot-oauth2-jwt-rest-protection



/*
 HTTP (REST Controller) StudentApi
    ↓
Input Port (PersonInputPort) StudentInputPort
    ↓
Use Case (PersonService) StudentUseCase
    ↓
Output Port (CrudOutputPort) 
    ↓
Repository Adapter (BaseRepository + Mapper) StudentRepositoryAdapter
    ↓
Spring Data JPA Repository StudentJpaRepository
    ↓
Database 
  
 */



@RestController
@RequestMapping(value = "/api/v1/alumno")
@PreAuthorize("hasAnyAuthority('ROLE_REALM_preceptor')")
public class StudentApi {
    
    private final StudentInputPort studentInputPort;
    
    //private final  StudentMapper studentMapper;
    private static final Logger logger = LoggerFactory.getLogger(StudentApi.class);

    public StudentApi(StudentInputPort studentInputPort) {
        this.studentInputPort = studentInputPort;
    }    

    @PostMapping(value = "create", produces=MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyAuthority('ROLE_RESOURCE_bsn_student:create')")
    public ResponseEntity<Student> create( @RequestBody @Valid Student student ) {
        logger.info("StudentApi, student parameter",student);
        return ResponseEntity.ok(studentInputPort.create(student));        
    }

    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
     public QueryResult<Student> /*List<Person>*/ getAll(@RequestParam @Valid int offset,@RequestParam @Valid int limit
        ,@RequestParam String qfilters,@RequestParam String sorts){
        logger.info("Filters: "+qfilters);
        List<QueryDto> queryFilters = Utils.stringToQueryFilterDto(qfilters);
        //queryFilters.add(QueryDto.builder().property("deleted:eq").value("false").build());

        List<QueryDto> sortFilters = Utils.stringToQueryFilterDto(sorts);
        return studentInputPort.getAll(offset, limit, queryFilters,sortFilters);      
    }        
    
    @GetMapping(value = "/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public Student getStudent(@PathVariable("id") Long id) {
        logger.info("ID de alumno a buscar: "+id);
        Optional<Student> studentOpt = studentInputPort.getById(id);
        if(studentOpt.isEmpty()){
            throw new RuntimeException("Alumno no encontrado");
        }
        Student student = studentOpt.get();
        logger.info("Alumno encontrado: "+student.getLastName());
        return student;
    }

    @PutMapping(value = "/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyAuthority('ROLE_RESOURCE_bsn_student:update')")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody @Valid Student student ) {
        logger.info("Student lastname: "+student.getLastName());
        return ResponseEntity.ok(studentInputPort.update(id,student));        
    }

    @DeleteMapping(value = "/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyAuthority('ROLE_RESOURCE_bsn_student:delete')")
    public ResponseEntity delete(@PathVariable Long id){
        logger.info("Student's id to be deleted: "+id);
        Student student = Student.builder().build();
        studentInputPort.delete(id, student);
        return ResponseEntity.ok("");
    }

    /*
    @GetMapping(value = "/list", produces =MediaType.APPLICATION_JSON_VALUE)
    public  QueryResult<Student> getAll( @RequestParam int offset,@RequestParam  int limit
        ,@RequestParam String qfilters, @RequestParam String sorts) {
        logger.info("Filters: "+qfilters);
        List<QueryDto> queryFilters = Utils.stringToQueryFilterDto(qfilters);
        queryFilters.add(QueryDto.builder().property("deleted:eq").value("false").build());

        List<QueryDto> sortFilters = Utils.stringToQueryFilterDto(sorts); 
        return baseInputPort.getAll(offset, limit, queryFilters,sortFilters);      
    }
    */
}
