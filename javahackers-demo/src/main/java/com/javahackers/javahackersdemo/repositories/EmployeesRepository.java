package com.javahackers.javahackersdemo.repositories;

import com.javahackers.javahackersdemo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface EmployeesRepository extends JpaRepository<Employee, String> {
    Collection<Employee> findByEmail(String email);
}
