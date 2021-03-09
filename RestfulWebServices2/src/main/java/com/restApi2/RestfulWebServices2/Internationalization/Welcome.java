package com.restApi2.RestfulWebServices2.Internationalization;

import java.lang.String;

import io.swagger.annotations.ApiModel;
import org.springframework.stereotype.Component;

@Component
@ApiModel(description = "This is a Welcome class")
public class Welcome {
    private String message;

    public Welcome(){};

    public Welcome(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
