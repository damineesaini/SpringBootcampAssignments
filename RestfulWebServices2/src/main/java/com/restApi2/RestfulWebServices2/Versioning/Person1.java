package com.restApi2.RestfulWebServices2.Versioning;

public class Person1 {
    private String name;

    public Person1(){
        super();
    }

    public Person1(String name){
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
