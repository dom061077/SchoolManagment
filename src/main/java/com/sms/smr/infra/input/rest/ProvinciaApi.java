package com.sms.smr.infra.input.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.model.Provincia;
import com.sms.smr.domain.ports.in.BaseUseCase;

@RestController
@RequestMapping(value = "/api/v1/provincia")
public class ProvinciaApi extends BaseApi<Provincia, Long> {

    public ProvinciaApi(BaseUseCase<Provincia, Long> provinciaInputPort) {
        super(provinciaInputPort);
    }
}
