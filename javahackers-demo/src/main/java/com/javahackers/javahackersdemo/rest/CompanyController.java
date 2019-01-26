package com.javahackers.javahackersdemo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/companies")
public class CompanyController extends AbstractController {

    private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @PostMapping("/")
    public @ResponseBody String authenticate() {
        // todo: generate user token and save it
        // todo: in case of wrong credentials return 403 Forbidden
        return "2";
    }

    @GetMapping("/")
    public ResponseEntity<String> getInitialInfo(@RequestHeader("Token") String token) {
        String id = getIdByToken(token);

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        // todo
        // buildCompanyInfo
        return new ResponseEntity<>("CompanyInfo", HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity addEmployees(@RequestHeader("Token") String token) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity updateEmployee() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/skips")
    public ResponseEntity updateSkips() {
        return new ResponseEntity(HttpStatus.OK);
    }
}
