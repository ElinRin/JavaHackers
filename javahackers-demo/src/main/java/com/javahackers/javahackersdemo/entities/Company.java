package com.javahackers.javahackersdemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Company {
    @Id
    @GeneratedValue
    private String id;

    @Column
    private String email;

    @Column
    private String passHash;

    @Column
    private String name;

    public Company() {
        super();
    }

    public Company(String email, String passHash, String name) {
        this.email = email;
        this.passHash = passHash;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassHash() {
        return passHash;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", passHash='" + passHash + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
