package com.sms.smr.infra.input.rest;

import com.sms.smr.domain.model.Localidad;
import com.sms.smr.domain.ports.in.BaseUseCase;
import com.sms.smr.infra.outputadapter.repositoryadapter.queryrepository.QueryResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1/ubicacion")
public class LocationApi {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(LocationApi.class);
    private final BaseUseCase<Localidad, Long> localidadInputPort;

    public LocationApi(BaseUseCase<Localidad, Long> localidadInputPort) {
        this.localidadInputPort = localidadInputPort;
    }



}
