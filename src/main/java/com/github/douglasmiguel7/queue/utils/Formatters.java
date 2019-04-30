package com.github.douglasmiguel7.queue.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatters {

    private static final SimpleDateFormat TIME = new SimpleDateFormat("HH:mm");

    private static final SimpleDateFormat DATE = new SimpleDateFormat("dd/MM/yyyy");

    private static final SimpleDateFormat TIMESTAMP = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    private Formatters() {

    }

    public static String toTime(Date date) {
        return date != null ? TIME.format(date) : null;
    }

    public static String toDate(Date date) {
        return date != null ? DATE.format(date) : null;
    }

    public static String toTimestamp(Date date) {
        return date != null ? TIMESTAMP.format(date) : null;
    }

    public static Date fromTimestamp(String timestamp) {
        try {
            return TIMESTAMP.parse(timestamp);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
