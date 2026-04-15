package com.sms.smr.infra.input.rest;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.model.Departamento;
import com.sms.smr.domain.model.Localidad;
import com.sms.smr.domain.ports.in.BaseQueryUseCase;
import com.sms.smr.domain.ports.in.BaseUseCase;
import com.sms.smr.domain.ports.out.QueryPersistenceOutputPort;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/localidad")
@RequiredArgsConstructor
public class LocalidadApi {
    private final BaseUseCase<Localidad, Long> localidadInputPort;
    private final BaseQueryUseCase<Departamento, Long> departamentoInputPort;
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(LocalidadApi.class);


    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Localidad> getAll(@RequestParam int offset, @RequestParam int limit,
                                  @RequestParam String qfilters, @RequestParam String sorts, 
                                  @RequestParam String loperator) {
        logger.info("qfilters: "+qfilters);                                    
        return localidadInputPort.getAll(offset, limit, qfilters, sorts, loperator);
    }

    @GetMapping(value = "departamentos-por-provincia/{idProvincia}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Departamento> getDepartamentoByProvincia(@PathVariable Long idProvincia) {
        logger.info("departamentos-por-provincia, idProvincia: "+idProvincia);
        int offset = 0;
        int limit = 10;
        String qfilters = "[{\"property\":\"provincia.id:eq\",\"value\":\""+idProvincia+"\"}]";
        String sorts = "[]";

        return departamentoInputPort.getAll(offset, limit, qfilters, sorts, QueryPersistenceOutputPort.AND_OPERATOR);
        
    }

    @GetMapping(value = "localidades-por-departamento/{idDepartamento}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Localidad> getLocalidadByDepartamento(@PathVariable Long idDepartamento) {
        logger.info("localidades-por-departamento, idDepartamento: "+idDepartamento);
        int offset = 0;
        int limit = 10;
        String qfilters = "[{\"property\":\"departamento.id:eq\",\"value\":\""+idDepartamento+"\"}]";
        String sorts = "[]";

        return localidadInputPort.getAll(offset, limit, qfilters, sorts, QueryPersistenceOutputPort.AND_OPERATOR);
    }

}
