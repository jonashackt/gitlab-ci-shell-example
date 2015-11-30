package de.jonashackt.restexamples.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restexamples")
public class Controller {

    public static final String RESPONSE = "Hello Rest-User!";
    
    @RequestMapping("hello")
    public String helloWorld() {
        return RESPONSE;
    }
}
