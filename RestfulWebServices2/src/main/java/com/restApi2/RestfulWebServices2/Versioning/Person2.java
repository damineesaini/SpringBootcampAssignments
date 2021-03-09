package com.restApi2.RestfulWebServices2.Versioning;

public class Person2 {
    Name name;

    public Person2(){
        super();
    }

    public Person2(Name name){
        super();
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
