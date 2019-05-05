package lambdasinaction.chap12;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author pengzhe
 * @date 2019-05-05 23:45
 * @description
 */

public class LocalDateTimeTest {
    public static void main(String[] args) {
        // localDateTime();
        //test();
        System.out.println(getOnline());
        System.out.println(getPre());
    }

    private static void localDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.toString());
    }

    private static void test() {
        Instant now = Instant.now();
        System.out.println(System.nanoTime());
    }

    private static String getOnline() {
        LocalDate localDate = getLocalDate();
        return localDate.format(DateTimeFormatter.BASIC_ISO_DATE);

    }

    private static String getPre() {
        StringBuilder stringBuilder = new StringBuilder();
        LocalDate localDate = getLocalDate();
        Month month = localDate.getMonth();
        int value = month.getValue();
        int dayOfMonth = localDate.getDayOfMonth();
        int value1 = localDate.getDayOfWeek().getValue();
        return stringBuilder.append(value).append(dayOfMonth).append(value1).toString();
    }

    private static LocalDate getLocalDate() {
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        Instant now = Instant.now();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(now, zoneId);
        return localDateTime.toLocalDate();
    }
}
