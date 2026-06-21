package com.sms.smr.infra.input.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sms.smr.domain.model.PageResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.model.Departamento;
import com.sms.smr.domain.model.Localidad;
import com.sms.smr.domain.ports.in.BaseQueryUseCase;
import com.sms.smr.domain.ports.in.BaseUseCase;
import com.sms.smr.domain.ports.out.QueryPersistenceOutputPort;

@RestController
@RequestMapping(value = "/api/v1/localidad")
public class LocalidadApi extends BaseApi<Localidad, Long> {

    private final BaseQueryUseCase<Departamento, Long> departamentoInputPort;
    private static final Logger logger = LoggerFactory.getLogger(LocalidadApi.class);

    public LocalidadApi(BaseUseCase<Localidad, Long> localidadInputPort,
                        BaseQueryUseCase<Departamento, Long> departamentoInputPort) {
        super(localidadInputPort);
        this.departamentoInputPort = departamentoInputPort;
    }

    @GetMapping(value = "departamentos-por-provincia/{idProvincia}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResponse<Departamento> getDepartamentoByProvincia(@PathVariable Long idProvincia) {
        logger.info("departamentos-por-provincia, idProvincia: {}", idProvincia);
        int offset = 0;
        int limit = 10;
        String qfilters = "[{\"property\":\"provincia.id:eq\",\"value\":\"" + idProvincia + "\"}]";
        String sorts = "[]";

        return departamentoInputPort.getAll(offset, limit, qfilters, sorts, QueryPersistenceOutputPort.AND_OPERATOR);
    }

    @GetMapping(value = "localidades-por-departamento/{idDepartamento}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResponse<Localidad> getLocalidadByDepartamento(@PathVariable Long idDepartamento) {
        logger.info("localidades-por-departamento, idDepartamento: {}", idDepartamento);
        int offset = 0;
        int limit = 10;
        String qfilters = "[{\"property\":\"departamento.id:eq\",\"value\":\"" + idDepartamento + "\"}]";
        String sorts = "[]";

        return useCase.getAll(offset, limit, qfilters, sorts, QueryPersistenceOutputPort.AND_OPERATOR);
    }
}
