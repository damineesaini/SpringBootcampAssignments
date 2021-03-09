package com.restApi2.RestfulWebServices2.ContentNegotiation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

@ApiModel(description = "This is a User Bean")
public class User {

    Integer id;

    @ApiModelProperty(notes ="name should only start with alphabet and contains alphabets and space.Its minimum no of characters allowed is 2.")
    @Pattern(regexp = "[a-zA-Z][a-zA-Z ]*")
    @Size(min = 2)
    String name;


    public User(Integer id,String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
