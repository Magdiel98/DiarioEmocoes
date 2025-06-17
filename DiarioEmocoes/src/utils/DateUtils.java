package utils;

import java.time.LocalDate;

public class DateUtils {
    public static String getMonthName(int month)
    {
        return LocalDate.of(2025, month, 1).getMonth().name();
    }
}
