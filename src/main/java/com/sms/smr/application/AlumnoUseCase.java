package com.sms.smr.application;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sms.smr.domain.Alumno;
import com.sms.smr.domain.Person;
import com.sms.smr.infra.inputadapter.dto.query.QueryFilterDto;
import com.sms.smr.infra.inputport.AlumnoInputPort;
import com.sms.smr.infra.outputadapter.db.AlumnoEntity;
import com.sms.smr.infra.outputadapter.db.PersonEntity;
import com.sms.smr.infra.outputadapter.jparepository.alumno.AlumnoRepository;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryRepository;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;
import com.sms.smr.infra.outputadapter.mapper.AlumnoEntityMapper;
import com.sms.smr.infra.outputport.EntityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AlumnoUseCase implements AlumnoInputPort{
    private static final Logger logger = LoggerFactory.getLogger(AlumnoUseCase.class);

    private final AlumnoRepository entityRepository;
    private final  AlumnoEntityMapper alumnoEntMapper;
    private final QueryRepository queryRepository;    

    @Override
    public Alumno createAlumno(Alumno alumno) {
        logger.info("Apellido de alumno: "+alumno.getApellido());
       return alumnoEntMapper.toDomain(entityRepository.save(alumnoEntMapper.toDbo(alumno)));
    }

    @Override
    public QueryResult<Alumno> getAll(int offset, int limit, List<QueryFilterDto> queryFilters,List<QueryFilterDto> sorts) {
    
        QueryResult<Alumno> qResult = new QueryResult<Alumno>();            

        qResult.setData(alumnoEntMapper.getAlumnos(queryRepository.getAllAnd(AlumnoEntity.class, offset, limit, queryFilters, sorts)));
        long count = queryRepository.getCount(PersonEntity.class, queryFilters);
        qResult.setTotal(count);

        return qResult;
    }

    @Override
    public Alumno getById(Long alumnoId) {
        
        return alumnoEntMapper.toDomain(entityRepository.getById(alumnoId));
    }
    
}
