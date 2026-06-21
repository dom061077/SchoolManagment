package com.sms.smr.infra.input.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sms.smr.domain.model.PageResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.sms.smr.domain.ports.in.BaseUseCase;
import jakarta.validation.Valid;

public abstract class BaseApi<T, ID> {

    protected final BaseUseCase<T, ID> useCase;
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public BaseApi(BaseUseCase<T, ID> useCase) {
        this.useCase = useCase;
    }

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> create(@RequestBody @Valid T entity) {
        logger.info("Creating entity: {}", entity);
        return ResponseEntity.ok(useCase.create(entity));
    }

    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResponse<T> getAll(@RequestParam int offset, @RequestParam int limit,
            @RequestParam(required = false, defaultValue = "[]") String qfilters,
            @RequestParam(required = false, defaultValue = "[]") String sorts,
            @RequestParam(required = false, defaultValue = "AND") String loperator) {
        logger.info("Fetching list with filters: {}", qfilters);
        return useCase.getAll(offset, limit, qfilters, sorts, loperator);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public T getById(@PathVariable("id") ID id) {
        logger.info("Fetching entity with id: {}", id);
        return useCase.getById(id).orElseThrow(() -> new RuntimeException("Entity not found"));
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<T> update(@PathVariable("id") ID id, @RequestBody @Valid T entity) {
        logger.info("Updating entity with id: {}", id);
        T updatedEntity = useCase.update(id, entity);
        return ResponseEntity.ok(useCase.getById(id).orElse(updatedEntity));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable("id") ID id) {
        logger.info("Deleting entity with id: {}", id);
        useCase.delete(id);
        return ResponseEntity.ok("");
    }
}
