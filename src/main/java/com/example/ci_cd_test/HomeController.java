package com.example.ci_cd_test;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String homepage() {
        return "hi! everyone this is anshika tamak from kurukshetra, Haryana , india................hope you are doing good";
    }

    @RequestMapping("/home")
    public String home() {
        return "this is the home page";
    }



}
