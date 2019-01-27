package com.javahackers.javahackersdemo.auxiliary;

import com.javahackers.javahackersdemo.entities.Company;
import com.javahackers.javahackersdemo.entities.Employee;
import com.javahackers.javahackersdemo.repositories.CompanyRepository;
import com.javahackers.javahackersdemo.repositories.EmployeesRepository;

import java.util.Collection;
import java.util.Optional;

public class RepositoriesHelper {
    EmployeesRepository employeesRepository;
    CompanyRepository companyRepository;

    public RepositoriesHelper(EmployeesRepository employeesRepository, CompanyRepository companyRepository) {
        this.employeesRepository = employeesRepository;
        this.companyRepository = companyRepository;
    }

    public Employee findEmployeeByEmail(String email) {
        Collection<Employee> employees = employeesRepository.findByEmail(email);

        if (employees.size() != 1) {
            return null;
        }

        return (Employee)employees.toArray()[0];
    }

    public Employee findEmployeeById(String id) {
        Optional<Employee> opt = employeesRepository.findById(id);
        return opt.orElse(null);
    }

    public Company findCompanyById(String id) {
        Optional<Company> opt = companyRepository.findById(id);
        return opt.orElse(null);
    }

    public EmployeeInfo findEmployeeInfoById(String id) {
        Employee employee = findEmployeeById(id);
        if (employee == null) {
            return null;
        }

        String companyId = employee.getCompanyId();
        Company company = findCompanyById(companyId);

        // todo
        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.companyName = company == null ? "null" : company.getName();
        employeeInfo.realMoney = 5L;
        employeeInfo.futureMoney = 6L;
        employeeInfo.costHour = 1L;
        employeeInfo.realDays = 3L;

        return employeeInfo;
    }

    public EmployeeInfo findEmployeeInfoByEmail(String email) {
        Employee employee = findEmployeeByEmail(email);
        if (employee == null) {
            return null;
        }

        return findEmployeeInfoById(employee.getId());
    }

    public CompanyInfo findCompanyInfoById(String id) {
        Company company = findCompanyById(id);
        if (company == null) {
            return null;
        }

        CompanyInfo info = new CompanyInfo();
        info.name = company.getName();

        return info;
    }
}
