package com.restApi2.RestfulWebServices2.ContentNegotiation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.*;

@ApiModel(description = "User Details")
public class User {
    @ApiModelProperty(notes ="used to recognize user uniquely")
    Integer id;

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
