package com.sms.smr.infra.ouput.persistence;

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
