
package com.javahackers.javahackersdemo.auxiliary;

import java.util.Date;

public class Utils {
    boolean isWorkDay(Date date) {
        Date today = new Date();
        int diffInDays = (int)( (date.getTime() - today.getTime())
                / (1000 * 60 * 60 * 24) );
        if (diffInDays%6 == 0 || diffInDays%7 == 0) {
            return false;
        } else {
            return true;
        }
    }

    Date reduceDayToFirst(Date date) {
        int month = date.getMonth();
        int year = date.getYear();

        Date result = new Date();
        result.setDate(1);
        result.setMonth(month);
        result.setYear(year);

        return result;
    }
}