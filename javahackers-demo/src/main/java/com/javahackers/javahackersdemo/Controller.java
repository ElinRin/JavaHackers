package com.javahackers.javahackersdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping("/hello")
    public String sayHello(@RequestParam(value = "name") String name) {
        return "<h1>Hello " + name + "!</h1>";
    }
}
