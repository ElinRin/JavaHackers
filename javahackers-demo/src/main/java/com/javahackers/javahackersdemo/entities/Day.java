package com.javahackers.javahackersdemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Day {
    @Id
    @GeneratedValue
    private String id;

    @Column
    private String employeeId;

    @Column
    private String date;

    @Column
    private boolean skip = false;

    @Column
    private boolean withdraw = false;

    public Day() {
        super();
    }

    public Day(String employeeId, String date, boolean skip, boolean withdraw) {
        super();
        this.employeeId = employeeId;
        this.date = date;
        this.skip = skip;
        this.withdraw = withdraw;
    }

    public String getId() {
        return id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getDate() {
        return date;
    }

    public boolean isSkip() {
        return skip;
    }

    public boolean isWithdraw() {
        return withdraw;
    }

    @Override
    public String toString() {
        return "Day{" +
                "id='" + id + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", date='" + date + '\'' +
                ", skip=" + skip +
                ", withdraw=" + withdraw +
                '}';
    }
}