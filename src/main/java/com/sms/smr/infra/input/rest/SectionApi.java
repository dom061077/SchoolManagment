package com.sms.smr.infra.input.rest;

import java.util.List;

import com.sms.smr.domain.model.PageResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.smr.domain.model.Section;
import com.sms.smr.domain.ports.in.BaseUseCase;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;
import com.sms.smr.infra.utils.Utils;

@RestController
@RequestMapping("/api/v1/section")
public class SectionApi extends BaseApi<Section, Long> {

    public SectionApi(BaseUseCase<Section, Long> sectionUseCase) {
        super(sectionUseCase);
    }

    @GetMapping(value = "/grade-level/{gradeLevelId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResponse<Section> getSectionsByGradeLevelId(
            @PathVariable("gradeLevelId") Long gradeLevelId,
            @RequestParam int offset,
            @RequestParam int limit,
            @RequestParam(required = false, defaultValue = "[]") String qfilters,
            @RequestParam(required = false, defaultValue = "[]") String sorts,
            @RequestParam(required = false, defaultValue = "AND") String loperator) {

        List<QueryDto> filters = Utils.stringToQueryFilterDto(qfilters);
        filters.add(QueryDto.builder().property("gradeLevels.id:eq").value(gradeLevelId.toString()).build());

        String newQfilters;
        try {
            newQfilters = new ObjectMapper().writeValueAsString(filters);
        } catch (Exception e) {
            newQfilters = qfilters;
            logger.error("Error serializing filters: {}", e.getMessage());
        }

        return useCase.getAll(offset, limit, newQfilters, sorts, loperator);
    }
}
