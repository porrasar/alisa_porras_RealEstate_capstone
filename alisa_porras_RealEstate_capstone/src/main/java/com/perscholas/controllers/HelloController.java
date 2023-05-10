package com.perscholas.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloController
{
    @GetMapping("/hello")
        public String sayHello()
    {
        return "alisa hello";
    }

    @GetMapping("/goodbye")
    public String sayGoodbye()
    {
        return "alisa goodbye";
    }
}
