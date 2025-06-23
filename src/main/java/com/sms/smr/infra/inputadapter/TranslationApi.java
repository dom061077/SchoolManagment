package com.sms.smr.infra.inputadapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.Translation;
import com.sms.smr.infra.inputport.BaseInputPort;

import lombok.RequiredArgsConstructor;

// TODO: Replace the following import with the correct package if TranslationMapper exists elsewhere
import com.sms.smr.infra.inputadapter.mapper.TranslationMapper;

@RestController
@RequestMapping(value="/api/v1/translation")
@RequiredArgsConstructor
public class TranslationApi {

    private static final Logger logger = LoggerFactory.getLogger(TranslationApi.class);
    @Qualifier(value="translationUseCase")
    private final BaseInputPort<Translation> baseInputPort;
    private final TranslationMapper translationMapper;

}
