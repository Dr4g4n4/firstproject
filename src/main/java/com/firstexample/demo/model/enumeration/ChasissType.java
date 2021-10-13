package com.firstexample.demo.model.enumeration;

public enum ChasissType {
    COUPE ("COUPE"),
    SEDAN ("SEDAN"),
    LIMOUSINE ("LIMOUSINE"),
    HOTHACH ("HOTHACH"),
    HATCHBACK ("HATCHBACK");

    private String value;

    ChasissType  (String value){
        this.value = value;
    }

}
