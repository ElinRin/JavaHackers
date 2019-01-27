package com.javahackers.javahackersdemo.restcontrollers;

import com.google.gson.Gson;
import com.javahackers.javahackersdemo.auxiliary.AuthInfo;
import com.javahackers.javahackersdemo.auxiliary.EmployeeInfo;
import com.javahackers.javahackersdemo.auxiliary.RepositoriesHelper;
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
@RequestMapping("/employee")
public class EmployeeController extends AbstractController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    // Map sessionToken:employeeId
    private Map<String, String> tokens = new HashMap<>();

    private final EmployeesRepository employeesRepository;
    private final CompanyRepository companyRepository;
    private final RepositoriesHelper repositories;


    @Autowired
    public EmployeeController(EmployeesRepository employeesRepository, CompanyRepository companyRepository) {
        this.employeesRepository = employeesRepository;
        this.companyRepository = companyRepository;
        this.repositories = new RepositoriesHelper(employeesRepository, companyRepository);
    }

    @PostMapping("/")
    public ResponseEntity<String> authenticate(@RequestBody String body) {

        AuthInfo authInfo = new Gson().fromJson(body, AuthInfo.class);
        Employee employee = repositories.findEmployeeByEmail(authInfo.email);

        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        // todo: compare hash
        if (!employee.getPassword().equals(authInfo.password)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        String sessionId = UUID.randomUUID().toString();
        tokens.put(sessionId, employee.getId());

        return new ResponseEntity<>(sessionId, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<String> getInitialInfo(@RequestHeader("Token") String token) {
        String id = tokens.getOrDefault(token, null);

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        EmployeeInfo employeeInfo = repositories.findEmployeeInfoById(id);
        if (employeeInfo == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(new Gson().toJson(employeeInfo), HttpStatus.OK);
    }

    @GetMapping("/info")
    public ResponseEntity<String> getInfo(@RequestHeader("Token") String token) {
        String id = tokens.getOrDefault(token, null);

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }


        Employee employee = repositories.findEmployeeById(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        EmployeeInfo info = repositories.findEmployeeInfoById(id);
        if (info == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(new Gson().toJson(info), HttpStatus.OK);
    }

    @PostMapping("/withdrawal")
    public ResponseEntity withdrawMoney(@RequestBody String request) {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/paylist")
    public @ResponseBody String getWithdrawalsHistory(@RequestBody String body) {
        logger.info("paylist called: " + body);
        return "paylistOk";
    }


}
