package com.javahackers.javahackersdemo.restcontrollers;

import com.google.gson.Gson;
import com.javahackers.javahackersdemo.auxiliary.AuthInfo;
import com.javahackers.javahackersdemo.auxiliary.CompanyInfo;
import com.javahackers.javahackersdemo.auxiliary.EmployeeInfo;
import com.javahackers.javahackersdemo.auxiliary.RepositoriesHelper;
import com.javahackers.javahackersdemo.entities.Company;
import com.javahackers.javahackersdemo.entities.Employee;
import com.javahackers.javahackersdemo.repositories.CompanyRepository;
import com.javahackers.javahackersdemo.repositories.EmployeesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/companies")
public class CompanyController extends AbstractController {

    private Map<String, String> tokens = new HashMap<>();

    private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
    private final RepositoriesHelper repositories;

    @Autowired
    public CompanyController(EmployeesRepository employeesRepository, CompanyRepository companyRepository) {
        this.repositories = new RepositoriesHelper(employeesRepository, companyRepository);
    }

    @PostMapping("/")
    public ResponseEntity<String> authenticate(@RequestBody String body) {
        AuthInfo authInfo = new Gson().fromJson(body, AuthInfo.class);
        Company company = repositories.findCompanyById(authInfo.email);

        if (company == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        // todo: compare hash
        if (!company.getPassword().equals(authInfo.password)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        String sessionToken = UUID.randomUUID().toString();
        tokens.put(sessionToken, company.getId());

        return new ResponseEntity<>(sessionToken, HttpStatus.OK);

    }

    @GetMapping("/")
    public ResponseEntity<String> getInitialInfo(@RequestHeader("Token") String token) {
        String id = tokens.getOrDefault(token, null);

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        CompanyInfo companyInfo = repositories.findCompanyInfoById(id);
        if (companyInfo == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(new Gson().toJson(companyInfo), HttpStatus.OK);

    }

    @PostMapping("/info")
    public ResponseEntity<String> getInfo(@RequestHeader("Token") String token, @RequestBody String body) {
        EmployeeInfo info = repositories.findEmployeeInfoByEmail(body);
        if (info == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new Gson().toJson(info), HttpStatus.OK);
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
