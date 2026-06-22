package com.sms.smr.domain.model;

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