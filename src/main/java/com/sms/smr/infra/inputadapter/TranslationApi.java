package com.sms.smr.infra.inputadapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.Translation;
import com.sms.smr.infra.inputport.BaseInputPort;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.sms.smr.infra.inputadapter.dto.translation.TranslationDto;
import com.sms.smr.infra.inputadapter.mapper.TranslationMapper;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping(value="/api/v1/translation")
@RequiredArgsConstructor
public class TranslationApi {


    @Qualifier(value="translationUseCase")
    private final BaseInputPort<Translation> baseInputPort;
    private final TranslationMapper translationMapper;
    private static final Logger logger = LoggerFactory.getLogger(TranslationApi.class);



    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)    
    @PreAuthorize("hasAnyAuthority('ROLE_REALM_ADMIN')")
    public TranslationDto create(@RequestBody @Valid TranslationDto transationDto ){
        return translationMapper.toDto(baseInputPort.create(translationMapper.toDomain(transationDto)));
    }

}
