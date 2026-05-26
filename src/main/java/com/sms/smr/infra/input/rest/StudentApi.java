package com.sms.smr.infra.input.rest;

import com.sms.smr.domain.model.Departamento;
import com.sms.smr.domain.model.Localidad;
import com.sms.smr.domain.model.Provincia;
import com.sms.smr.domain.model.Student;
import com.sms.smr.domain.ports.in.BaseQueryUseCase;
import com.sms.smr.domain.ports.in.BaseUseCase;
import com.sms.smr.domain.ports.in.StudentUseCase;
import com.sms.smr.domain.ports.out.QueryPersistenceOutputPort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
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
public class StudentApi extends BaseApi<Student, Long> {
    
    private final BaseUseCase<Provincia, Long> provinciaInputPort;
    private final BaseQueryUseCase<Departamento, Long> departamentoInputPort;
    private final BaseUseCase<Localidad, Long> localidadInputPort;
    private final StudentUseCase studentUseCase;
    
    public StudentApi(StudentUseCase studentInputPort,
                      BaseUseCase<Provincia, Long> provinciaInputPort,
                      BaseQueryUseCase<Departamento, Long> departamentoInputPort,
                      BaseUseCase<Localidad, Long> localidadInputPort) {
        super(studentInputPort);
        this.studentUseCase = studentInputPort;
        this.provinciaInputPort = provinciaInputPort;
        this.departamentoInputPort = departamentoInputPort;
        this.localidadInputPort = localidadInputPort;
    }

    @GetMapping(value = "search", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Student> searchStudents(
            @RequestParam(required = false) Integer dni,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String firstName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        logger.info("Searching students by dni: {}, lastName: {}, firstName: {}", dni, lastName, firstName);
        return studentUseCase.searchStudents(dni, lastName, firstName, page, size);
    }

    @GetMapping(value = "provincias", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Provincia> getAllProvincias(@RequestParam int offset, @RequestParam int limit
        ,@RequestParam String qfilters, @RequestParam String sorts,@RequestParam String loperator){
        logger.info("Filters: "+qfilters);
        return provinciaInputPort.getAll(offset, limit, qfilters,sorts,loperator);      
    }

    @GetMapping(value = "departamentos", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Departamento> getDepartamentoByProvincia(@RequestParam int offset, @RequestParam int limit
        ,@RequestParam String qfilters, @RequestParam String sorts, @RequestParam String loperator){
        logger.info("Filters: "+qfilters);
        return departamentoInputPort.getAll(offset, limit, qfilters,sorts,loperator);
    }

    @GetMapping(value = "localidades", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Localidad> getLocalidadByDepartamento(@RequestParam int offset, @RequestParam int limit
        ,@RequestParam String qfilters, @RequestParam String sorts, @RequestParam String loperator){
        logger.info("Filters: "+qfilters);
        return localidadInputPort.getAll(0, limit, qfilters,sorts,QueryPersistenceOutputPort.AND_OPERATOR);
    }
}

/*
src/main/java/com/app/student/
├── domain/                         <-- THE HEXAGON (No Spring/JPA dependencies)
│   ├── model/                      
│   │   └── StudentRegistration.java (Plain Java Object) | Student.java
│   ├── ports/
│   │   ├── in/                     <-- INPUT PORTS (What the app CAN do)
│   │   │   ├── RegisterStudentUseCase.java | BaseUseCase.java
│   │   │   └── GetStudentUseCase.java
│   │   └── out/                    <-- OUTPUT PORTS (What the app NEEDS)
│   │       └── StudentPersistencePort.java | CrudPersistenceOutputPort.java - QueryPersistenceOutputPort.java
│   └── service/                    <-- INTERACTORS (Business Logic)
│       └── RegisterStudentService.java (Implements RegisterStudentUseCase) 
|       └-- StudentService.java (Implements BaseUseCase and AUTOWIRES both CrudPersistenceOutputPort(StudentPersistenceAdapter) and QueryPersistenceOutputPort (StudetnQueryAdapter))    
│
└── infrastructure/                 <-- THE ADAPTERS (Spring/JPA/External)
    ├── input/                      <-- PRIMARY ADAPTERS (Driving)
    │   └── rest/
    │       ├── StudentController.java
    │       ├── RegisterStudentRequest.java (DTO)
    │       └── StudentResponse.java (DTO)
    └── output/                     <-- SECONDARY ADAPTERS (Driven)
        └── persistence/
            ├── StudentPersistenceAdapter.java (Implements StudentPersistencePort | CrudPersistenceOutputPort and AUTOWIRES StudentEntityMapper and StudentJpaRepository)
            |-- StudentQueryAdapter.java (Implements QueryPersistenceOutputPort) 
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