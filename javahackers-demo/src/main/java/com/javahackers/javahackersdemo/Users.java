package com.javahackers.javahackersdemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Users {
    @Id
    @GeneratedValue
    Long id;

    @Column
    String name;

    @Column
    Long tariff;
}
