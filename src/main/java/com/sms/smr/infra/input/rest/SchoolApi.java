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

import com.sms.smr.domain.model.School;
import com.sms.smr.domain.ports.in.BaseUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/school")
@PreAuthorize("hasAnyAuthority('ROLE_REALM_preceptor')")
@RequiredArgsConstructor
public class SchoolApi {

    private final BaseUseCase<School, Long> schoolUseCase;
    private static final Logger logger = LoggerFactory.getLogger(SchoolApi.class);

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<School> create(@RequestBody @Valid School school) {
        logger.info("SchoolApi, school parameter: {}", school);
        return ResponseEntity.ok(schoolUseCase.create(school));
    }

    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<School> getAll(@RequestParam int offset, @RequestParam int limit,
                              @RequestParam String qfilters, @RequestParam String sorts, @RequestParam String loperator) {
        logger.info("Filters: {}", qfilters);
        return schoolUseCase.getAll(offset, limit, qfilters, sorts, loperator);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public School getSchool(@PathVariable("id") Long id) {
        logger.info("School ID to find: {}", id);
        Optional<School> schoolOpt = schoolUseCase.getById(id);
        if (schoolOpt.isEmpty()) {
            throw new RuntimeException("School not found");
        }
        School school = schoolOpt.get();
        logger.info("School found: {}", school.getName());
        return school;
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<School> update(@PathVariable Long id, @RequestBody @Valid School school) {
        logger.info("School: {}", school.getName());
        School savedSchool = schoolUseCase.update(id, school);
        logger.info("School saved: {}", savedSchool.getName());
        Optional<School> schoolOpt = schoolUseCase.getById(id);
        return ResponseEntity.ok(schoolOpt.get());
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable Long id) {
        logger.info("School's id to be deleted: {}", id);
        schoolUseCase.delete(id);
        return ResponseEntity.ok("");
    }
}
