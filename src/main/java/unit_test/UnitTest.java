package unit_test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UnitTest {
    public static void main(String[] args) {
        String date = ("2022-09-09T00:00:00Z");
        System.out.println("Year: " + extractYearFromISODate(date) + "\nMonth: " + extractMonthFromISODate(date));
    }

    private static String extractYearFromISODate(String isoExtendedDate) {
        return String.valueOf(LocalDateTime.parse(isoExtendedDate, DateTimeFormatter.ISO_DATE_TIME).getYear());
    }

    private static String extractMonthFromISODate(String isoExtendedDate) {
        return LocalDateTime.parse(isoExtendedDate, DateTimeFormatter.ISO_DATE_TIME).getMonth().name();
    }
}