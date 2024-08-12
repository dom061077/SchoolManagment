package com.sms.smr.infra.inputadapter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sms.smr.domain.Person;
import com.sms.smr.infra.inputadapter.dto.query.QueryFilterDto;
import com.sms.smr.infra.inputadapter.dto.PersonDto;
import com.sms.smr.infra.outputadapter.mapper.PersonEntityMapper;
import com.sms.smr.infra.inputadapter.mapper.PersonMapper;
import com.sms.smr.infra.inputport.PersonInputPort;
import com.sms.smr.infra.outputadapter.db.PersonEntity;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

import net.sf.jasperreports.engine.JRException;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping(value="/api/v1/person")
@RequiredArgsConstructor
public class PersonApi {
    private final PersonInputPort personInputPort;
    private final PersonMapper personMapper;
    private final PersonEntityMapper personEntityMapper;
    private static final Logger logger = LoggerFactory.getLogger(PersonApi.class); 



     @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)   
    public PersonDto create(@RequestBody @Valid PersonDto personDto){
      return personMapper.personToPersonDto(personInputPort.createPerson(personMapper.personDtoToPerson(personDto)));
      
    }
 
    @GetMapping("/{id}")
    public PersonDto getPerson(@PathVariable Long id) {
        return personMapper.personToPersonDto( personInputPort.getById(id));
    }


    @PutMapping("/{id}")
    public PersonDto updatePerson(@PathVariable Long id, @RequestBody @Valid PersonDto personDto) {
        //TODO: process PUT request
        Person person = personMapper.personDtoToPerson(personDto);
        return personMapper.personToPersonDto(personInputPort.updatePerson(id,person));
    }
    

    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public QueryResult<Person> /*List<Person>*/ getAll(int offset, int limit, String qfilters, String sorts){
        logger.info("Filters: "+qfilters);
        ObjectMapper objectMapper = new ObjectMapper();
        List<QueryFilterDto> queryFilters = new ArrayList();
        JsonNode jsonArray;
        try{
            jsonArray = objectMapper.readTree(qfilters);
            for(JsonNode element : jsonArray){
                QueryFilterDto queryFilter = objectMapper.treeToValue(element, QueryFilterDto.class);
                queryFilters.add(queryFilter);
            }
        }catch(Exception e){
            logger.error("Error al parsear filters JSON: "+e.getMessage());
        }
        List<QueryFilterDto> sortFilters = new ArrayList<QueryFilterDto>();
        try{
            jsonArray = objectMapper.readTree(sorts);
            for(JsonNode element : jsonArray){
                QueryFilterDto sortFilter = objectMapper.treeToValue(element, QueryFilterDto.class);
                sortFilters.add(sortFilter); 
            }
        }catch(Exception e){
            logger.error("Error al parsear sorts JSON: "+e.getMessage());
        }
 
        return personInputPort.getAll(offset, limit, queryFilters,sortFilters);      
    }

    @GetMapping(value = "certificate")
    public void getPersonCertificateReport(Long personId,HttpServletResponse response) throws IOException, JRException{
        


        File file = ResourceUtils.getFile("classpath:church_certificate.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        ArrayList<QueryFilterDto> queryFilters = new ArrayList<QueryFilterDto>();
        QueryFilterDto qFilterDto = QueryFilterDto.builder().build();
        qFilterDto.setProperty("id:eq");
        qFilterDto.setValue(personId.toString());
        queryFilters.add(qFilterDto);
        QueryResult<Person> qResult = personInputPort.getAll(0,1,queryFilters,null);
        List<Person> persons = qResult.getData();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(persons);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Simplifying Tech");
        //Fill Jasper report
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        //Export report
        JasperExportManager.exportReportToPdfStream(jasperPrint,response.getOutputStream());

    }

}
