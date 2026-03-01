package com.sms.smr.infra.input.rest;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.model.Translation;
import com.sms.smr.domain.ports.in.BaseUseCase;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.inputadapter.mapper.TranslationMapper;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryResult;
import com.sms.smr.infra.utils.Utils;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



//@RestController
@RequestMapping(value="/api/v1/translation")
@RequiredArgsConstructor
public class TranslationApi {


    @Qualifier(value="translationUseCase")
    private final BaseUseCase<Translation, Long> baseUseCase;
    private final TranslationMapper translationMapper;
    private static final Logger logger = LoggerFactory.getLogger(TranslationApi.class);



    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)    
    @PreAuthorize("hasAnyAuthority('ROLE_REALM_ADMIN')")
    public Translation create(@RequestBody @Valid Translation translation ){
        logger.info("translationDto: ",translation);
        return baseUseCase.create(translation);
    }

    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyAuthority('ROLE_REALM_ADMIN')")
    public Page<Translation> getAll(@RequestParam int offset, @RequestParam int limit
    , @RequestParam String qfilters, @RequestParam String sorts, @RequestParam String loperator) {
        logger.info("Filters: "+qfilters);
        return baseUseCase.getAll(offset, limit, qfilters, sorts, loperator);
    }

    @GetMapping(value = "messages/{lang}", produces = MediaType.APPLICATION_JSON_VALUE)
    //@PreAuthorize("hasAnyAuthority('ROLE_REALM_ADMIN')")  
    public Map<String, Object> getMessages(@PathVariable String lang) {
        logger.info("Language: " + lang);
        Map<String, Object> result = new LinkedHashMap<>();
        List<Translation> translations = baseUseCase.getAll(0, 100
            //, Utils.stringToQueryFilterDto("[]"), Utils.stringToQueryFilterDto("[]")).getData();
            ,"[{\"property\":\"language:eq\", \"value\":\""+lang+"\" }]", "[]","AND").getContent();
        
        for(Translation t : translations ) {
            result.computeIfAbsent(t.getNamespace(), k-> new LinkedHashMap<>());
            Map<String, String> group = (Map<String, String>) result.get(t.getNamespace());
            group.put(t.getKey(), t.getValue());
        }   

        
        return result ; 
    }
}
