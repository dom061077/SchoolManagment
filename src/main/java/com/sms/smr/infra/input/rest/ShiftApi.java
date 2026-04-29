package com.sms.smr.infra.input.rest;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.model.Shift;
import com.sms.smr.domain.ports.in.BaseUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/shift")
@PreAuthorize("hasAnyAuthority('ROLE_REALM_preceptor')")
@RequiredArgsConstructor
public class ShiftApi {

    private final BaseUseCase<Shift, Long> shiftUseCase;
    private static final Logger logger = LoggerFactory.getLogger(ShiftApi.class);

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shift> create(@RequestBody @Valid Shift shift) {
        logger.info("ShiftApi, shift parameter", shift);
        return ResponseEntity.ok(shiftUseCase.create(shift));
    }

    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Shift> getAll(@RequestParam int offset, @RequestParam int limit,
                              @RequestParam String qfilters, @RequestParam String sorts, @RequestParam String loperator) {
        logger.info("Filters: " + qfilters);
        return shiftUseCase.getAll(offset, limit, qfilters, sorts, loperator);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Shift getShift(@PathVariable("id") Long id) {
        logger.info("Shift ID to find: " + id);
        Optional<Shift> shiftOpt = shiftUseCase.getById(id);
        if (shiftOpt.isEmpty()) {
            throw new RuntimeException("Shift not found");
        }
        Shift shift = shiftOpt.get();
        logger.info("Shift found: " + shift.getName());
        return shift;
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shift> update(@PathVariable Long id, @RequestBody @Valid Shift shift) {
        logger.info("Shift: {} ", shift.getName());
        Shift savedShift = shiftUseCase.update(id, shift);
        logger.info("Shift saved: {} ", savedShift.getName());
        Optional<Shift> shiftOpt = shiftUseCase.getById(id);
        return ResponseEntity.ok(shiftOpt.get());
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable Long id) {
        logger.info("Shift's id to be deleted: " + id);
        shiftUseCase.delete(id);
        return ResponseEntity.ok("");
    }
}
