package com.sms.smr.infra.inputadapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.smr.domain.Person;
import com.sms.smr.infra.inputadapter.dto.PersonDto;
import com.sms.smr.infra.inputadapter.dto.query.QueryFilterDto;
import com.sms.smr.infra.inputadapter.mapper.PersonMapper;
import com.sms.smr.infra.inputport.PersonInputPort;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;





@RestController
@RequestMapping(value="/api/v1/person")
@RequiredArgsConstructor
public class PersonApi {
    private final PersonInputPort personInputPort;
    private final PersonMapper personMapper;
    private static final Logger logger = LoggerFactory.getLogger(PersonApi.class); 



     @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)   
    public PersonDto create(@RequestBody @Valid PersonDto personDto){
       return personMapper.personToPersonDto(personInputPort.createPerson(personMapper.personDtoToPerson(personDto)));
      
    }

    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getAll(int offset, int limit, String qfilters){
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
        return personInputPort.getAll(offset, limit, queryFilters);      
    }

}
