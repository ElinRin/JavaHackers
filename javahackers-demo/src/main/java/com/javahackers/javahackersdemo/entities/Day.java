package com.javahackers.javahackersdemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class Day {
    @Id
    @GeneratedValue
    private String id;

    @Column
    private String employeeId;

    @Column
    private Date date;

    @Column
    private boolean skip = false;

    @Column
    private boolean withdraw = false;

    public Day() {
        super();
    }

    public Day(String employeeId, Date date, boolean skip, boolean withdraw) {
        super();
        this.employeeId = employeeId;
        this.date = date;
        this.skip = skip;
        this.withdraw = withdraw;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public void setWithdraw(boolean withdraw) {
        this.withdraw = withdraw;
    }

    public String getId() {
        return id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public Date getDate() {
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