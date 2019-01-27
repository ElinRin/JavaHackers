package com.javahackers.javahackersdemo.repositories;

import com.javahackers.javahackersdemo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employee, String> {
    Employee findByEmail(String email);
}
