package com.javahackers.javahackersdemo.restcontrollers;

import com.google.gson.Gson;
import com.javahackers.javahackersdemo.auxiliary.AuthInfo;
import com.javahackers.javahackersdemo.entities.Employee;
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
    private Map<String, String> sessions = new HashMap<>();

    private final EmployeesRepository employeesRepository;

    @Autowired
    public EmployeeController(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @PostMapping("/")
    public ResponseEntity<String> authenticate(@RequestBody String body) {

        AuthInfo authInfo = new Gson().fromJson(body, AuthInfo.class);
        Employee employee = employeesRepository.findByEmail(authInfo.email);

        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
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
        String id = getIdByToken(token);

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        // todo
        // builduserinfo
        return new ResponseEntity<>("employeeInfo", HttpStatus.OK);
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
