package com.restApi2.RestfulWebServices2.Filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ApiModel(description = "this is a user bean used for static filter implementation")
public class UserStaticFilterBean{
    Integer id;

    @Pattern(regexp = "[a-zA-Z][a-zA-Z ]*")
    @Size(min = 2)
    String name;


    @JsonIgnore
    @Pattern(regexp = "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$")
    @ApiModelProperty(notes = "Password must contains minimum length 8,one capital letter, one small letter, one number and one special character " )
    String password;

    public UserStaticFilterBean(Integer id,String name,String password){
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
