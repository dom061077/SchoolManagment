package com.sms.smr.infra.inputadapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.Person;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.inputadapter.dto.PersonDto;
import com.sms.smr.infra.inputadapter.mapper.PersonMapper;
import com.sms.smr.infra.inputadapter.utils.Utils;
import com.sms.smr.infra.inputport.BaseInputPort;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.io.InputStream;

import net.sf.jasperreports.engine.JRException;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping(value="/api/v1/person")
@RequiredArgsConstructor
public class PersonApi {
    @Qualifier(value="personUseCase")
    private final BaseInputPort<Person> baseInputPort;
    private final PersonMapper personMapper;
    private static final Logger logger = LoggerFactory.getLogger(PersonApi.class); 



     @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)   
    public PersonDto create(@RequestBody @Valid PersonDto personDto){
      return personMapper.personToPersonDto(baseInputPort.create(personMapper.personDtoToPerson(personDto)));
      
    }
 
    @GetMapping("/{id}")
    public PersonDto getPerson(@PathVariable Long id) {
        return personMapper.personToPersonDto( baseInputPort.getById(id).get());
    }


    @PutMapping("/{id}")
    public PersonDto updatePerson(@PathVariable Long id, @RequestBody @Valid PersonDto personDto) {

        Person person = personMapper.personDtoToPerson(personDto);
        return personMapper.personToPersonDto(baseInputPort.update(id,person).get());
    }
    
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_REALM_CHURCH','ROLE_RESOURCE_bsn_CHURCH')")
    public ResponseEntity<?> deletePerson(@PathVariable Long id) {
        if(baseInputPort.delete(id))
            return ResponseEntity.ok(Map.of("Message","Person marked as deleted"));
        return ResponseEntity.noContent().build();
    }


    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyAuthority('ROLE_REALM_CHURCH','ROLE_RESOURCE_bsn_CHURCH')")
     public QueryResult<Person> /*List<Person>*/ getAll(@RequestParam @Valid int offset,@RequestParam @Valid int limit
        ,@RequestParam String qfilters,@RequestParam String sorts){
        logger.info("Filters: "+qfilters);
        /*ObjectMapper objectMapper = new ObjectMapper();
        List<QueryDto> queryFilters = new ArrayList();
        JsonNode jsonArray;
        try{
            jsonArray = objectMapper.readTree(qfilters);
            for(JsonNode element : jsonArray){
                QueryDto queryFilter = objectMapper.treeToValue(element, QueryDto.class);
                queryFilters.add(queryFilter);
            }
        }catch(Exception e){
            logger.error("Error al parsear filters JSON: "+e.getMessage());
        }
        List<QueryDto> sortFilters = new ArrayList<QueryDto>();
        try{
            jsonArray = objectMapper.readTree(sorts);
            for(JsonNode element : jsonArray){
                QueryDto sortFilter = objectMapper.treeToValue(element, QueryDto.class);
                sortFilters.add(sortFilter); 
            }
        }catch(Exception e){
            logger.error("Error al parsear sorts JSON: "+e.getMessage());
        }*/
        List<QueryDto> queryFilters = Utils.stringToQueryFilterDto(qfilters);
        queryFilters.add(QueryDto.builder().property("deleted:eq").value("false").build());

        List<QueryDto> sortFilters = Utils.stringToQueryFilterDto(sorts);
        return baseInputPort.getAll(offset, limit, queryFilters,sortFilters);      
    }

    @GetMapping(value = "certificate")
    public void getPersonCertificateReport(Long personId,HttpServletResponse response) throws IOException, JRException{
        

        InputStream inputStream = getClass().getResourceAsStream("/reports/church_certificate.jrxml"); 
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream); 

        //File file = ResourceUtils.getFile("classpath:church_certificate.jrxml");
        //JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        ArrayList<QueryDto> queryFilters = new ArrayList<QueryDto>();
        QueryDto qFilterDto = QueryDto.builder().build();
        qFilterDto.setProperty("id:eq");
        qFilterDto.setValue(personId.toString());
        queryFilters.add(qFilterDto);
        QueryResult<Person> qResult = baseInputPort.getAll(0,1,queryFilters,null);
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
