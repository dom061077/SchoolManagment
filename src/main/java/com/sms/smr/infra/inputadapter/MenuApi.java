package com.sms.smr.infra.inputadapter;

import java.util.List;
import java.util.Optional;

import javax.management.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.smr.domain.Menu;
import com.sms.smr.infra.exception.InternalServerErrorException;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.inputadapter.utils.Utils;
import com.sms.smr.infra.inputport.BaseInputPort;
import com.sms.smr.infra.outputadapter.jparepository.queryrepository.QueryResult;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value="/api/v1/menu")
@RequiredArgsConstructor
public class MenuApi {
    
    private final static Logger logger = LoggerFactory.getLogger(MenuApi.class);

    @Qualifier(value="menuUseCase")
    private final BaseInputPort<Menu> baseInputPort;

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('ROLE_REALM_ADMIN')")
    public Menu create(@RequestBody @Valid Menu menu) {
        logger.info("Creating menu with code: {}", menu.getCode());
        return baseInputPort.create(menu);
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Menu getMenu(@PathVariable Long id) {
        logger.info("Retrieving menu with id: {}", id);
        // Assuming getById returns an Optional<Menu>);
        Optional<Menu> menuOpt = baseInputPort.getById(id);
        if(menuOpt.isEmpty()) {
            logger.error("Menu not found with id: {}", id);
            throw new InternalServerErrorException("Menu not found with id: " + id);
        }else {
            return menuOpt.get();
        }
        
    }

    public QueryResult<Menu> getAllMenus(@RequestParam int offset, @RequestParam int limit
            , @RequestParam String qfilters, @RequestParam String sorts) {
        logger.info("Retrieving all menus");
        logger.info("Filters: {}, Sorts: {}", qfilters, sorts);
        List<QueryDto> queryFilters = Utils.stringToQueryFilterDto(qfilters);
        queryFilters.add(QueryDto.builder().property("deleted:eq").value("false").build());
        List<QueryDto> querySorts = Utils.stringToQueryFilterDto(sorts);
        return baseInputPort.getAll(offset,limit, queryFilters, querySorts); 
    } 

}
