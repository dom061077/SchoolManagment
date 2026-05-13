package com.sms.smr.infra.input.rest;

import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import com.sms.smr.domain.model.Shift;
import com.sms.smr.domain.ports.in.BaseUseCase;

@RestController
@RequestMapping(value = "/api/v1/shift")
@PreAuthorize("hasAnyAuthority('ROLE_REALM_preceptor')")
public class ShiftApi extends BaseApi<Shift, Long> {

    public ShiftApi(BaseUseCase<Shift, Long> shiftUseCase) {
        super(shiftUseCase);
    }

    @GetMapping(value = "/grade-level/{gradeLevelId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Shift> getShiftByGradeLevelId(@PathVariable("gradeLevelId") Long gradeLevelId,
            @RequestParam int offset, @RequestParam int limit,
            @RequestParam(required = false, defaultValue = "[]") String qfilters,
            @RequestParam(required = false, defaultValue = "[]") String sorts,
            @RequestParam(required = false, defaultValue = "AND") String loperator) {
        logger.info("Fetching list with filters: {}", qfilters);
        return useCase.getAll(offset, limit, qfilters, sorts, loperator);
    }
}
