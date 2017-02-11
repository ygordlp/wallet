package br.edu.unifor.ewallet.util;

import java.nio.channels.CancelledKeyException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Renan on 11/02/2017.
 */

public class Util {

    public static Date getStartOfMonth(Date date) {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static String getMonthName(Date date) {
        String[] monthName = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
                "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" };

        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        return monthName[cal.get(Calendar.MONTH)];
    }

    public static int getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        return cal.get(Calendar.YEAR);
    }

}
