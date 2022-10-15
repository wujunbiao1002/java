package com.wjb.java.basic;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;

/**
 * <b><code>DateTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/2/22 13:26.
 *
 * @author Arjun
 * @version 1.0.0
 * @since java 0.1.0
 */
public class DateClassDemo {
    @Test
    public void unitDate(){
        Date date = new Date();
        System.out.println(date.getTime());
    }

    @Test
    public void sqlDate(){
        java.sql.Date date = new java.sql.Date(new Date().getTime());
        System.out.println(date);
    }

    @Test
    public void simpleDateFormat(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("日期yyyy-MM-dd hh:mm:ss:SS");

        System.out.println(formatter.format(date));

        try {
            Date parse = formatter.parse("日期2022-02-22 01:58:55:515");
            System.out.println(parse.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void calendar(){
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));

        calendar.add(Calendar.DAY_OF_MONTH, 7);
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
    }

    @Test
    public void localDateTest(){
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localDateTime);
        //get
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getSecond());
        System.out.println(localDateTime.getNano());

        LocalDate localDate1 = localDate.plusDays(2);
        System.out.println(localDate1.getDayOfMonth());
        System.out.println(localDate.getDayOfMonth());

        LocalDate localDate2 = localDate.minusDays(2);
        System.out.println(localDate2.getDayOfMonth());
    }

    @Test
    public void instant(){
        Instant now = Instant.now();
        System.out.println(now);

        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
    }
    @Test
    public void formatter(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        isoLocalDateTime.format(now);
        System.out.println(now);


        // 本地格式化方式
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(now));
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).format(now));
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(now));

        LocalDateTime time = LocalDateTime.now();
        System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).format(time));
        System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(time));
        System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(time));

        // 自定义
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter.format(time));
    }
}
