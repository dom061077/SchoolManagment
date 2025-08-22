package com.sms.smr.application;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sms.smr.domain.Student;
import com.sms.smr.domain.Person;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.inputport.StudentInputPort;
import com.sms.smr.infra.outputadapter.db.StudentEntity;
import com.sms.smr.infra.outputadapter.db.PersonEntity;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepository;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;
import com.sms.smr.infra.outputadapter.jparepository.student.AlumnoRepository;
import com.sms.smr.infra.outputadapter.mapper.StudentEntityMapper;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class StudentUseCase implements StudentInputPort{
    private static final Logger logger = LoggerFactory.getLogger(StudentUseCase.class);
    @Qualifier(value="studentRepository")
    private final EntityRepository<StudentEntity> entityRepository;
    private final  StudentEntityMapper alumnoEntMapper;
    private final QueryRepository queryRepository;    

    @Override
    public Student createStudent(Student student) {
        logger.info("Apellido de alumno: "+alumno.getApellido());
       return alumnoEntMapper.toDomain(entityRepository.save(alumnoEntMapper.toDbo(alumno)));
    }

    @Override
    public QueryResult<Student> getAll(int offset, int limit, List<QueryDto> queryFilters,List<QueryDto> sorts) {
    
        QueryResult<Student> qResult = new QueryResult<Student>();            

        qResult.setData(alumnoEntMapper.getAlumnos(queryRepository.getAllAnd(StudentEntity.class, offset, limit, queryFilters, sorts)));
        long count = queryRepository.getCount(PersonEntity.class, queryFilters);
        qResult.setTotal(count);

        return qResult;
    }

    @Override
    public Student getById(Long alumnoId) {
        
        return entityRepository.getById(alumnoId)
                .map(obj -> (StudentEntity) obj)
                .map(alumnoEntMapper::toDomain)
                .orElseThrow(() -> new IllegalArgumentException("Alumno not found with ID: " + alumnoId));
    }
    
}
