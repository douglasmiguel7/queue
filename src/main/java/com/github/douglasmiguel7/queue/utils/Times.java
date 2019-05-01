package com.github.douglasmiguel7.queue.utils;

import java.time.*;
import java.util.Date;

public class Times {

    private Times() {

    }

    public static Date of(int hour) {
        return of(hour, 0);
    }

    public static Date of(int hour, int minute) {
        LocalDate now = LocalDate.now();

        LocalTime localTime = LocalTime.of(hour, minute);

        LocalDateTime localDateTime = localTime.atDate(now);

        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();

        Date date = Date.from(instant);

        return date;
    }

}
