package com.javahackers.javahackersdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyNameAndEmplyeeListController {
    @RequestMapping("/company")
    public String sayHello(@RequestParam(value = "id") String id) {
        return "<h1>Company Tinkoff Bank " + id + " Oleg Tinkoff works here!</h1>";
    }
}

