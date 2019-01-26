package com.javahackers.javahackersdemo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping("/")
    public @ResponseBody String authenticate() {
        // todo: generate user token and save it
        return "1";
    }

    @GetMapping("/paylist")
    public @ResponseBody String getWithdrawalsHistory(@RequestBody String body) {
        logger.info("paylist called: " + body);
        return "paylistOk";
    }

    @PostMapping("/withdraw")
    public ResponseEntity withdrawMoney() {
        return new ResponseEntity(HttpStatus.OK);
    }


}
