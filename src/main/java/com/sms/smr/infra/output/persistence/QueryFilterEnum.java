package com.sms.smr.infra.output.persistence;

import lombok.Getter;

@Getter
enum QueryFilterEnum {
    eq,
    neq,
    gt,
    like,
    eqin,
    lt;
    


    /*private final String fieldValue;

    QueryFilterEnum(String fieldValue){
        this.fieldValue = fieldValue;
    }*/


}
