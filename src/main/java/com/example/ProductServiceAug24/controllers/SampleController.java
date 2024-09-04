package com.example.ProductServiceAug24.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SampleController {

    @GetMapping("/hello" )
    public String helloworld(){

        return "Hello World";
    }

    @GetMapping("/hello/{name}")

    public String hello(@PathVariable("name")String name){
        return "Hare Krishna "+ name + " Prabhu";
    }
}
