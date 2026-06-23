package com.sms.smr.infra.input.rest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.model.Person;
import com.sms.smr.domain.ports.in.BaseUseCase;

@RestController
@RequestMapping(value="/api/v1/person")
@PreAuthorize("hasAnyAuthority('ROLE_REALM_CHURCH','ROLE_RESOURCE_bsn_CHURCH')")
public class PersonApi extends BaseApi<Person, Long> {

    public PersonApi(@Qualifier("personUseCase") BaseUseCase<Person, Long> baseInputPort) {
        super(baseInputPort);
    }
}

