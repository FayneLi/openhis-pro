package com.whale.common.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


/**
 * 时间处理工具类
 */
public class TimeUtils {
    private static final ZoneId DEFAULT_ZONE = ZoneId.systemDefault();
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(DEFAULT_ZONE);

    /**
     * 解析时间字符串
     */
    public static LocalTime parseTime(String timeStr) {
        if (timeStr == null) {
            throw new IllegalArgumentException("时间未设定");
        }

        try {
            if (timeStr.length() == 4) {
                // 处理"0200"格式
                int hours = Integer.parseInt(timeStr.substring(0, 2));
                int minutes = Integer.parseInt(timeStr.substring(2, 4));
                return LocalTime.of(hours, minutes);
            } else if (timeStr.contains(":")) {
                // 处理"HH:mm"格式
                return LocalTime.parse(timeStr, DateTimeFormatter.ofPattern("HH:mm"));
            } else {
                throw new IllegalArgumentException("不支持的时间格式: " + timeStr);
            }
        } catch (Exception e) {
            throw new RuntimeException("时间解析失败: " + timeStr, e);
        }
    }

    /**
     * LocalTime转Date
     */
    public static Date localTimeToDate(LocalTime localTime) {
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), localTime);
        return Date.from(localDateTime.atZone(DEFAULT_ZONE).toInstant());
    }

    /**
     * Date转LocalDate
     */
    public static LocalDate dateToLocalDate(Date date) {
        return date.toInstant().atZone(DEFAULT_ZONE).toLocalDate();
    }

    /**
     * Date转字符串(HH:mm:ss)
     */
    public static String dateToTimeString(Date date) {
        return date.toInstant()
                .atZone(DEFAULT_ZONE)
                .toLocalTime()
                .format(TIME_FORMATTER);
    }

    /**
     * Date转字符串(yyyy-MM-dd)
     */
    public static String dateToDateString(Date date) {
        return date.toInstant()
                .atZone(DEFAULT_ZONE)
                .toLocalDate()
                .format(DATE_FORMATTER);
    }

    /**
     * 解析日期时间字符串
     */
    public static LocalDateTime parseDateTime(String dateStr) {
        return LocalDateTime.parse(dateStr, DATE_TIME_FORMATTER);
    }
}
