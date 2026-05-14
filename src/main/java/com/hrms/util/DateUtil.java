package com.hrms.util;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private DateUtil() {

    }

    // Format Date
    public static String formatDate(
            LocalDate date) {

        return date.format(formatter);
    }

    // Parse Date
    public static LocalDate parseDate(
            String date) {

        return LocalDate.parse(date, formatter);
    }
}
