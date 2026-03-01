package com.sms.smr.infra.input.rest;

import com.sms.smr.domain.model.Departamento;
import com.sms.smr.domain.model.Localidad;
import com.sms.smr.domain.model.Provincia;
import com.sms.smr.domain.model.Student;
import com.sms.smr.domain.ports.in.BaseUseCase;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.inputport.StudentInputPort;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryResult;
import com.sms.smr.infra.utils.Utils;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
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
@RequiredArgsConstructor
public class StudentApi {
    
    private final BaseUseCase<Student, Long> studentInputPort;
    private final BaseUseCase<Provincia, Long> provinciaInputPort;
    private final BaseUseCase<Departamento, Long> departamentoInputPort;
    private final BaseUseCase<Localidad, Long> localidadInputPort;
    
    //private final  StudentMapper studentMapper;
    private static final Logger logger = LoggerFactory.getLogger(StudentApi.class);

    /*public StudentApi(StudentInputPort studentInputPort,ProvinciaInputPort ProvinciaInputPort) {
        this.studentInputPort = studentInputPort;
        this.provinciaInputPort = ProvinciaInputPort;

    } */   

    @PostMapping(value = "create", produces=MediaType.APPLICATION_JSON_VALUE)
    //@PreAuthorize("hasAnyAuthority('ROLE_RESOURCE_bsn_student:create')")
    public ResponseEntity<Student> create( @RequestBody @Valid Student student ) {
        logger.info("StudentApi, student parameter",student);
        return ResponseEntity.ok(studentInputPort.create(student));        
    }

    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
     public Page<Student> /*List<Person>*/ getAll(@RequestParam  int offset,@RequestParam  int limit
        ,@RequestParam String qfilters,@RequestParam String sorts,@RequestParam String loperator){
        logger.info("Filters: "+qfilters);
        //List<QueryDto> queryFilters = Utils.stringToQueryFilterDto(qfilters);
        //queryFilters.add(QueryDto.builder().property("deleted:eq").value("false").build());

        ///List<QueryDto> sortFilters = Utils.stringToQueryFilterDto(sorts);
        return studentInputPort.getAll(offset, limit, qfilters,sorts,loperator);      
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
    //@PreAuthorize("hasAnyAuthority('ROLE_RESOURCE_bsn_student:update')")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody @Valid Student student ) {
        logger.info("Student lastname: "+student.getLastName());
        return ResponseEntity.ok(studentInputPort.update(id,student));        
    }

    @DeleteMapping(value = "/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    //@PreAuthorize("hasAnyAuthority('ROLE_RESOURCE_bsn_student:delete')")
    public ResponseEntity delete(@PathVariable Long id){
        logger.info("Student's id to be deleted: "+id);
        //Student student = Student.builder().build();
        studentInputPort.delete(id);
        return ResponseEntity.ok("");
    }

    @GetMapping(value = "provincias", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Provincia> getAllProvincias(@RequestParam int offset, @RequestParam int limit
        ,@RequestParam String qfilters, @RequestParam String sorts,@RequestParam String loperator){
        logger.info("Filters: "+qfilters);
        //List<QueryDto> queryFilters = Utils.stringToQueryFilterDto(qfilters);
        //queryFilters.add(QueryDto.builder().property("deleted:eq").value("false").build());

        //List<QueryDto> sortFilters = Utils.stringToQueryFilterDto(sorts);
        return provinciaInputPort.getAll(offset, limit, qfilters,sorts,loperator);      
    }

    @GetMapping(value = "departamentos", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Departamento> getDepartamentoByProvincia(@RequestParam int offset, @RequestParam int limit
        ,@RequestParam String qfilters, @RequestParam String sorts, @RequestParam String loperator){
        logger.info("Filters: "+qfilters);
        //List<QueryDto> queryFilters = Utils.stringToQueryFilterDto(qfilters);

        //List<QueryDto> sortFilters = Utils.stringToQueryFilterDto(sorts);
        return departamentoInputPort.getAll(offset, limit, qfilters,sorts,loperator);
    }

    @GetMapping(value = "localidades", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Localidad> getLocalidadByDepartamento(@RequestParam int offset, @RequestParam int limit
        ,@RequestParam String qfilters, @RequestParam String sorts, @RequestParam String loperator){
        logger.info("Filters: "+qfilters);
        //List<QueryDto> queryFilters = Utils.stringToQueryFilterDto(qfilters);

        //List<QueryDto> sortFilters = Utils.stringToQueryFilterDto(sorts);
        return localidadInputPort.getAll(offset, limit, qfilters,sorts,loperator);
    }


    
}

/*
src/main/java/com/app/student/
├── domain/                         <-- THE HEXAGON (No Spring/JPA dependencies)
│   ├── model/                      
│   │   └── StudentRegistration.java (Plain Java Object)
│   ├── ports/
│   │   ├── in/                     <-- INPUT PORTS (What the app CAN do)
│   │   │   ├── RegisterStudentUseCase.java
│   │   │   └── GetStudentUseCase.java
│   │   └── out/                    <-- OUTPUT PORTS (What the app NEEDS)
│   │       └── StudentPersistencePort.java
│   └── service/                    <-- INTERACTORS (Business Logic)
│       └── RegisterStudentService.java (Implements RegisterStudentUseCase)
│
└── infrastructure/                 <-- THE ADAPTERS (Spring/JPA/External)
    ├── input/                      <-- PRIMARY ADAPTERS (Driving)
    │   └── rest/
    │       ├── StudentController.java
    │       ├── RegisterStudentRequest.java (DTO)
    │       └── StudentResponse.java (DTO)
    └── output/                     <-- SECONDARY ADAPTERS (Driven)
        └── persistence/
            ├── StudentPersistenceAdapter.java (Implements StudentPersistencePort)
            ├── StudentRegistrationEntity.java (JPA Entity)
            ├── StudentRegistrationJpaRepository.java (Spring Data)
            └── StudentPersistenceMapper.java (The Bridge)

The "Golden Thread" (Execution Flow)
Request: An HTTP POST hits the StudentController.

DTO Mapping: The controller converts RegisterStudentRequest to the StudentRegistration domain model.

Use Case: The controller calls RegisterStudentUseCase.execute(domainModel).

Business Logic: RegisterStudentService runs validations. If everything is okay, it calls the Output Port (StudentPersistencePort.save()).

Adapter: The StudentPersistenceAdapter receives the domain model, uses the Mapper to turn it into an Entity, and calls jpaRepository.save().

Return Path: The saved entity is mapped back to a domain object and flows all the way back to the controller to be returned as JSON.

Why this setup is "Senior Level"
The Suffixes: UseCase tells you it's a business action; Port tells you it's a contract; Adapter tells you it's a technical implementation.

The BaseRepository: Your BaseRepository lives in a shared common or base folder within infrastructure, keeping the repetitive CRUD code out of your clean domain services.

Testability: You can now write a unit test for RegisterStudentService by mocking StudentPersistencePort without ever starting a database or a Spring context.

*/