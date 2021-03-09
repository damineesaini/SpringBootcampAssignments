package com.restApi2.RestfulWebServices2.Filtering;


import io.swagger.annotations.ApiModel;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ApiModel(description = "this is a user bean used for dynamic filter implementation")
public class UserDynamicFilterBean {
    Integer id;

    @Pattern(regexp = "[a-zA-Z][a-zA-Z ]*")
    @Size(min = 2)
    String name;

    @Pattern(regexp = "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$")
    String password;

    public UserDynamicFilterBean(Integer id,String name,String password){
        this.id = id;
        this.name = name;
        this.password = password;
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
