package com.javahackers.javahackersdemo.db;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
class Day {
    @Id
    private Date date;

    public Day(Date date, boolean skipped, boolean withdrawn) {
        super();
        this.date = date;
        this.skipped = skipped;
        this.withdrawn = withdrawn;
    }

    @Override
    public String toString() {
        return "Day{" +
                "date=" + date +
                ", skipped=" + skipped +
                ", withdrawn=" + withdrawn +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public boolean isSkipped() {
        return skipped;
    }

    public boolean isWithdrawn() {
        return withdrawn;
    }

    public Day() {
        super();
    }


    private boolean skipped = false;
    private boolean withdrawn = false;
}