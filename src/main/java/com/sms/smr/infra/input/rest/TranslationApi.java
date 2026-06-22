package com.sms.smr.infra.input.rest;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.model.Translation;
import com.sms.smr.domain.ports.in.BaseUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/api/v1/translation")
public class TranslationApi extends BaseApi<Translation, Long> {

    private static final Logger logger = LoggerFactory.getLogger(TranslationApi.class);

    public TranslationApi(BaseUseCase<Translation, Long> baseUseCase) {
        super(baseUseCase);
    }

    @Override
    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)    
    @PreAuthorize("hasAnyAuthority('ROLE_REALM_ADMIN')")
    public ResponseEntity<Translation> create(@RequestBody @Valid Translation entity) {
        return super.create(entity);
    }

    @GetMapping(value = "messages/{lang}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> getMessages(@PathVariable String lang) {
        logger.info("Language: " + lang);
        Map<String, Object> result = new LinkedHashMap<>();
        List<Translation> translations = useCase.getAll(0, 100
            ,"[{\"property\":\"language:eq\", \"value\":\""+lang+"\" }]", "[]","AND").getContent();
        
        for(Translation t : translations ) {
            result.computeIfAbsent(t.getNamespace(), k-> new LinkedHashMap<>());
            @SuppressWarnings("unchecked")
            Map<String, String> group = (Map<String, String>) result.get(t.getNamespace());
            group.put(t.getKey(), t.getValue());
        }   
        
        return result ; 
    }
}
