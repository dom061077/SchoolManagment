package com.sms.smr.infra.input.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.model.Shift;
import com.sms.smr.domain.ports.in.BaseUseCase;

@RestController
@RequestMapping(value = "/api/v1/shift")
@PreAuthorize("hasAnyAuthority('ROLE_REALM_preceptor')")
public class ShiftApi extends BaseApi<Shift, Long> {

    public ShiftApi(BaseUseCase<Shift, Long> shiftUseCase) {
        super(shiftUseCase);
    }
}
