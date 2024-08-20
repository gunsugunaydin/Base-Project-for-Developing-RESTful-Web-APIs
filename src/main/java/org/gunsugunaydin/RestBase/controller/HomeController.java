package org.gunsugunaydin.RestBase.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Home Controller", description = "controller for home -for testing purposes")
public class HomeController {

    @GetMapping("/api/hello")
    public String hello(){
        return "Hello World";
    }
}
