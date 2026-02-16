package com.sms.smr.infra.inputadapter;

import com.sms.smr.domain.Localidad;
import com.sms.smr.infra.inputport.BaseInputPort;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1/ubicacion")
public class LocationApi {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(LocationApi.class);
    private final BaseInputPort<Localidad, Long> localidadInputPort;

    public LocationApi(BaseInputPort<Localidad, Long> localidadInputPort) {
        this.localidadInputPort = localidadInputPort;
    }

    @GetMapping(value = "/list", produces = "application/json")
    public QueryResult<Localidad> getAll(int offset, int limit) {
        return localidadInputPort.getAll(offset, limit, null, null);
    }


}
