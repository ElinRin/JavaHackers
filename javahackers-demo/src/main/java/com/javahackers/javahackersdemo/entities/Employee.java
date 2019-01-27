package com.javahackers.javahackersdemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    String id;

    @Column
    private String companyId;

    @Column
    private String name;

    @Column
    private Long salary;

    @Column
    private String email;

    @Column
    private String schedule;

    @Column
    private String passHash;

    public Employee() {
        super();
    }

    public Employee(String companyId, String name, Long salary, String email, String schedule) {
        super();
        this.companyId = companyId;
        this.name = name;
        this.salary = salary;
        this.email = email;
        this.schedule = schedule;
    }

    public String getId() {
        return id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getName() {
        return name;
    }

    public Long getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public String getSchedule() {
        return schedule;
    }

    public String getPassHash() {
        return passHash;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", companyId='" + companyId + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", email='" + email + '\'' +
                ", schedule='" + schedule + '\'' +
                ", passHash='" + passHash + '\'' +
                '}';
    }
}
