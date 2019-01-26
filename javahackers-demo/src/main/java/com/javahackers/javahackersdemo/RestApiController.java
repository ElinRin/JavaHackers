package com.javahackers.javahackersdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


@RestController
public class RestApiController {

    private static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @RequestMapping("/hello")
    public String sayHello(@RequestParam(value = "name") String name) {
        return "<h1>Hello " + name + "!</h1>";
    }

    @GetMapping("/updateDay/{userId}/{date}/{skipped}")
    public String updateMissing(@PathVariable Long userId, @PathVariable String date, @PathVariable Boolean skipped) {
        System.out.println(userId);
        System.out.println(date);
        System.out.println(skipped);

        return "<h1>" + userId + " " + date + " " + skipped + "</h1>";
    }

    @PostMapping("/companies/{companyId}/employees")
    public String addEmployees(@PathVariable String companyId) {
        throw new NotImplementedException();
    }

    @PostMapping("/companies/skips")
    public String updateSkips() {
        throw new NotImplementedException();
    }


}
