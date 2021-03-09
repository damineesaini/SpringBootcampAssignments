package com.restApi2.RestfulWebServices2.Internalization;

import java.lang.String;

import org.springframework.stereotype.Component;

@Component
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

//    @Override
//    public String toString(){
//        return String.format(LocaleContextHolder.getLocale(),"%s",message);
//    }

}
