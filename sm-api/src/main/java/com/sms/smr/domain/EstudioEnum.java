package com.sms.smr.domain;

public  enum EstudioEnum{
    ESTUDIO_COMPLETO("Completo"),
    ESTUDIO_INCOMPLETO("Incompleto");
    
    
    private String name;
    
    EstudioEnum(String name){
        this.name=name;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
    

}   