package org.launchcode.IndigenoUS_Seed_Exchange_Network.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello world!";
    }

}