package com.sms.smr.infra.inputadapter.utils;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.smr.infra.inputadapter.dto.query.QueryDto;

public class Utils {
    private static final Logger logger = LoggerFactory.getLogger(Utils.class);

    public static List<QueryDto> stringToQueryFilterDto(String queryString){
        ObjectMapper objectMapper = new ObjectMapper();
        List<QueryDto> queryFilters = new ArrayList();
        JsonNode jsonArray;
        try{
            jsonArray = objectMapper.readTree(queryString);
            for(JsonNode element : jsonArray){
                QueryDto queryFilter = objectMapper.treeToValue(element, QueryDto.class);
                queryFilters.add(queryFilter);
            }
            
            
        }catch(Exception e){
            logger.error("Error al parsear filters JSON: "+e.getMessage());
        }        
        return queryFilters;
    }
}
