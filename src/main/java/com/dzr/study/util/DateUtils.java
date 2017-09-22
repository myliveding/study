package com.dzr.study.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author dingzr
 * @Description
 * @ClassName DateUtils
 * @since 2017/9/15 17:26
 */
public class DateUtils {

    private static ZoneId zone = ZoneId.systemDefault();


    public static void main(String[] args) {
        System.err.println(zone);
    }

}
