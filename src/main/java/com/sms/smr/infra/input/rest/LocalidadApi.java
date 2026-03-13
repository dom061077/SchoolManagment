package com.sms.smr.infra.input.rest;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.model.Localidad;
import com.sms.smr.domain.ports.in.BaseUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/localidad")
@RequiredArgsConstructor
public class LocalidadApi {
    private final BaseUseCase<Localidad, Long> localidadInputPort;

    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Localidad> getAll(@RequestParam int offset, @RequestParam int limit,
                                  @RequestParam String qfilters, @RequestParam String sorts, 
                                  @RequestParam String loperator) {
        return localidadInputPort.getAll(offset, limit, qfilters, sorts, loperator);
    }

}
