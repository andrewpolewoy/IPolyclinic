package com.it_academy.jd2.model.patient.enums;

public enum HealthStatus {
    POSITIV,
    NEGATIV;
    public static HealthStatus  getStatus(String status){
        if(POSITIV.name().equals(status)){
            return POSITIV;
        }
        if(NEGATIV.name().equals(status)){
            return NEGATIV;
        }
        else return null;
    }

}