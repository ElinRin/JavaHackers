package com.javahackers.javahackersdemo.repositories;

import com.javahackers.javahackersdemo.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {
}
