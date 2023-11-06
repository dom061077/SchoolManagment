package com.sms.smr.infra.outputadapter.jparepository.queryrepository;

import lombok.Getter;

@Getter
enum QueryFilterEnum {
    EQUAL("eq"),
    NOT_EQUAL("neq"),
    GREATER_THAN("gt"),
    LIKE("like"),
    LESS_THAN("lt");


    private final String fieldValue;

    QueryFilterEnum(String fieldValue){
        this.fieldValue = fieldValue;
    }


}
