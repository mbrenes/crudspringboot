package com.firstapp.crudspringboot.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping(value ="api/hello")
    public String sayHello () {
        return "Hello World";
    }


}


