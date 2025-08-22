package com.sms.smr.infra.inputadapter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.Translation;
import com.sms.smr.infra.inputport.BaseInputPort;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;


import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.inputadapter.dto.translation.TranslationDto;
import com.sms.smr.infra.inputadapter.mapper.TranslationMapper;
import com.sms.smr.infra.inputadapter.utils.Utils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value="/api/v1/translation")
@RequiredArgsConstructor
public class TranslationApi {


    @Qualifier(value="translationUseCase")
    private final BaseInputPort<Translation> baseInputPort;
    private final TranslationMapper translationMapper;
    private static final Logger logger = LoggerFactory.getLogger(TranslationApi.class);



    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)    
    @PreAuthorize("hasAnyAuthority('ROLE_REALM_ADMIN')")
    public TranslationDto create(@RequestBody @Valid TranslationDto transLationDto ){
        logger.info("translationDto: ",transLationDto);
        return translationMapper.toDto(baseInputPort.create(translationMapper.toDomain(transLationDto)));
    }

    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyAuthority('ROLE_REALM_ADMIN')")
    public QueryResult<Translation> getAll(@RequestParam int offset, @RequestParam int limit
    , @RequestParam String qfilters, @RequestParam String sorts) {
        //logger.info("Filters: "+qfilters);
        List<QueryDto> queryFilters = Utils.stringToQueryFilterDto("");
        List<QueryDto> sortFilters = Utils.stringToQueryFilterDto("");
        return baseInputPort.getAll(offset, limit, queryFilters, sortFilters);
    }

    @GetMapping(value = "messages/{lang}", produces = MediaType.APPLICATION_JSON_VALUE)
    //@PreAuthorize("hasAnyAuthority('ROLE_REALM_ADMIN')")  
    public Map<String, Object> getMessages(@PathVariable String lang) {
        logger.info("Language: " + lang);
        Map<String, Object> result = new LinkedHashMap<>();
        List<Translation> translations = baseInputPort.getAll(0, 100
            //, Utils.stringToQueryFilterDto("[]"), Utils.stringToQueryFilterDto("[]")).getData();
            , Utils.stringToQueryFilterDto("[{\"property\":\"language:eq\", \"value\":\""+lang+"\" }]"), Utils.stringToQueryFilterDto("[]")).getData();
        
        for(Translation t : translations ) {
            result.computeIfAbsent(t.getNamespace(), k-> new LinkedHashMap<>());
            Map<String, String> group = (Map<String, String>) result.get(t.getNamespace());
            group.put(t.getKey(), t.getValue());
        }   

        
        return result ; 
    }
}
