package com.rest.RestfulWebService1.Ques1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    // Ques 1 to display welcome message
    @GetMapping("/")
    public String welcomePage(){
        return "Welcome to spring boot";
    }
}
