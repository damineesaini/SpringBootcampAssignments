package com.rest.RestfulWebService1;

import javax.validation.constraints.*;

public class Employee {

    private Integer id;

    @Pattern(regexp = "[a-zA-Z][a-zA-Z ]*")
    private String name;

    @Min(value = 18)
    @Max(value = 60)
    private Integer age;

    public Employee(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
