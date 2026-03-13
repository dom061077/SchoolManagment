package com.sms.smr.infra.input.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.model.Provincia;
import com.sms.smr.domain.ports.in.BaseUseCase;

@RestController
@RequestMapping(value = "/api/v1/provincia")
public class ProvinciaApi {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ProvinciaApi.class);
    private final BaseUseCase<Provincia, Long> provinciaInputPort;

    public ProvinciaApi(BaseUseCase<Provincia, Long> provinciaInputPort) {
        this.provinciaInputPort = provinciaInputPort;
    }

    @GetMapping(value = "list", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public org.springframework.data.domain.Page<com.sms.smr.domain.model.Provincia> getAll(
            @RequestParam int offset, 
            @RequestParam int limit,
            @RequestParam String qfilters, 
            @RequestParam String sorts, 
            @RequestParam String loperator) {
        logger.info("Getting all provincias with filters: " + qfilters);
        return provinciaInputPort.getAll(offset, limit, qfilters, sorts, loperator);
    }


}
