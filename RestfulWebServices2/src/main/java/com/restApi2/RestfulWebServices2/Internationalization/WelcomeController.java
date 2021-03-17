package com.restApi2.RestfulWebServices2.Internationalization;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping
    @ApiModelProperty(notes = "good morning message according to locale")
    public String welcome(){
        return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
    }


    @GetMapping("/param")
    @ResponseBody
    @ApiModelProperty(notes = "displays name given in params along with good morning message")
    public String welcomeName(@RequestParam(name = "name",defaultValue = "Guest") String name){
        String greet =messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
        return String.format("%s %s!", greet, name);
    }
}
