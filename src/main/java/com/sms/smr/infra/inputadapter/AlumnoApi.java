package com.sms.smr.infra.inputadapter;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.sms.smr.infra.inputadapter.dto.AlumnoDto;
import com.sms.smr.infra.inputadapter.dto.alumno.AlumnoDtoAfterPost;
import com.sms.smr.infra.inputadapter.dto.query.QueryFilterDto;
import com.sms.smr.infra.inputadapter.mapper.AlumnoMapper;
import com.sms.smr.infra.inputport.AlumnoInputPort;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
//https://auth0.com/blog/how-to-automatically-map-jpa-entities-into-dtos-in-spring-boot-using-mapstruct/
//https://www.toptal.com/spring/spring-boot-oauth2-jwt-rest-protection
@RestController
@RequestMapping(value = "alumno")
@RequiredArgsConstructor
public class AlumnoApi {
    
    
    private final AlumnoInputPort alumnoInputPort;
    
    private final  AlumnoMapper alumnoMapper;
    private static final Logger logger = LoggerFactory.getLogger(AlumnoApi.class);

    @PostMapping(value = "create", produces=MediaType.APPLICATION_JSON_VALUE)
    public AlumnoDtoAfterPost create( @RequestBody @Valid AlumnoDto alumnoDtoPost ) {
        logger.info("DTO recibido: "+alumnoDtoPost.getApellido());
        return alumnoMapper.alumnoToAlumnoDtoAfterPost(alumnoInputPort.createAlumno (alumnoMapper.alumnoPostDtoToAlumno(alumnoDtoPost)));
    }

    @GetMapping(value = "/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public AlumnoDto getAlumno(@PathVariable("id") Long id) {
        logger.info("ID de alumno a buscar: "+id);
        return alumnoMapper.alumnoToAlumnoDto(alumnoInputPort.getById(id));
    }

    @GetMapping(value = "/list", produces =MediaType.APPLICATION_JSON_VALUE)
    public  List<AlumnoDto> getAll( @RequestParam int offset,@RequestParam  int limit,@RequestParam String qfilters) {
        logger.info("Filters: "+qfilters);
        ObjectMapper objectMapper = new ObjectMapper();
        List<QueryFilterDto> queryFilters = new ArrayList();
        try{
            JsonNode jsonArray = objectMapper.readTree(qfilters);
            for(JsonNode element : jsonArray){
                QueryFilterDto queryFilter = objectMapper.treeToValue(element, QueryFilterDto.class);
                queryFilters.add(queryFilter);
            }
        }catch(Exception e){

        }
        //return queryFilters ;
        return alumnoMapper.getAlumnoDtos(alumnoInputPort.getAll(offset, limit, queryFilters));
    }
}
