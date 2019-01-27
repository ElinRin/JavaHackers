package com.javahackers.javahackersdemo.repositories;

import com.javahackers.javahackersdemo.entities.Day;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Day, String> {
}
