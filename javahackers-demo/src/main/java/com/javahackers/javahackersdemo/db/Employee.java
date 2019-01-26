package com.javahackers.javahackersdemo.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    Long id;

    @Column
    String name;

    @Column
    Long tariff;

    @Column
    String schedule;
}
