package com.javahackers.javahackersdemo.restcontrollers;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
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

import java.util.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController extends AbstractController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    // Map sessionToken:employeeId
    private Map<String, String> sessions = new HashMap<>();

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
        if (!employee.getPassHash().equals(authInfo.password)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, employee.getId());

        return new ResponseEntity<>(sessionId, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<String> getInitialInfo(@RequestHeader("Token") String token) {
        String id = sessions.getOrDefault(token, null);

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        EmployeeInfo employeeInfo = repositories.getEmployeeInfoById(id);
        if (employeeInfo == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(new Gson().toJson(employeeInfo), HttpStatus.OK);
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
