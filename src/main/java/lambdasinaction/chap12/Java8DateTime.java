package lambdasinaction.chap12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.util.Locale;

/**
 * @author pengzhe
 * @date 2019-05-05 22:31
 * @description
 */

public class Java8DateTime {

    public static void main(String[] args) {
        useLocalDate();
    }

    /**
     * LocalDate和LocalTime使用
     */
    private static void useLocalDate() {
        LocalDate date = LocalDate.now();
        int year = date.getYear();
        Month month = date.getMonth();
        int dayOfMonth = date.getDayOfMonth();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int lengthOfMonth = date.lengthOfMonth();
        boolean leapYear = date.isLeapYear();
        System.out.println(year);
        System.out.println(month);
        System.out.println(dayOfMonth);
        System.out.println(dayOfWeek);
        System.out.println(lengthOfMonth);
        System.out.println(leapYear);

        System.out.println("--------------------");

        System.out.println(date.get(ChronoField.YEAR));
        System.out.println(date.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(date.get(ChronoField.DAY_OF_MONTH));

        System.out.println("-----------Time--------------");

        LocalTime localTime = LocalTime.of(13, 45, 20);
        int hour = localTime.getHour();
        int minute = localTime.getMinute();
        int second = localTime.getSecond();
        System.out.println(hour);
        System.out.println(minute);
        System.out.println(second);

        System.out.println("-----------parse--------------");
        LocalDate date1 = LocalDate.parse("2019-05-05");
        LocalDate time = LocalDate.parse("21:49:40");


    }
}
