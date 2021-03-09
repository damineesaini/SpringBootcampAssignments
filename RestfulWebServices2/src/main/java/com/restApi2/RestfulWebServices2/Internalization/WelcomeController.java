package com.restApi2.RestfulWebServices2.Internalization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class WelcomeController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/welcome-internalization")
    public String welcome(){
        return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
    }


    @GetMapping(path = "/welcome")
    @ResponseBody
    public String welcomeName(@RequestParam(name = "name",defaultValue = "Guest") String name){
        String greet =messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
        return String.format("%s %s!", greet, name);
    }
}
