package com.sms.smr.infra.inputadapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.Menu;
import com.sms.smr.infra.inputport.BaseInputPort;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value="/api/v1/menu")
@RequiredArgsConstructor
public class MenuApi {
    
    private final static Logger logger = LoggerFactory.getLogger(MenuApi.class);

    @Qualifier(value="menuUseCase")
    private final BaseInputPort<Menu> baseInputPort;

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Menu create(@RequestBody @Valid Menu menu) {
        logger.info("Creating menu with code: {}", menu.getCode());
        return baseInputPort.create(menu);
    }


}
