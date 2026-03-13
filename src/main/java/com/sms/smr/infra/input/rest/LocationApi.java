package com.sms.smr.infra.input.rest;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.model.Localidad;
import com.sms.smr.domain.ports.in.BaseUseCase;


@RestController
@RequestMapping(value = "/api/v1/ubicacion")
public class LocationApi {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(LocationApi.class);
    private final BaseUseCase<Localidad, Long> localidadInputPort;

    public LocationApi(BaseUseCase<Localidad, Long> localidadInputPort) {
        this.localidadInputPort = localidadInputPort;
    }

    @GetMapping(value = "localidades", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Localidad> getLocalidadByDepartamento(@RequestParam int offset, @RequestParam int limit
        ,@RequestParam String qfilters, @RequestParam String sorts, @RequestParam String loperator){
        logger.info("Filters: "+qfilters);
        //List<QueryDto> queryFilters = Utils.stringToQueryFilterDto(qfilters);

        //List<QueryDto> sortFilters = Utils.stringToQueryFilterDto(sorts);
        return localidadInputPort.getAll(offset, limit, qfilters,sorts,loperator);
    }


}
