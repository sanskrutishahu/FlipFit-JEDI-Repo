package com.flipkart.java17;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;

public class DateTime {
    private static void displayCurrentDate8to11() {

//        // older approach
//
//        Date currentDate=new Date();
//
//        System.out.println("current date-->" +currentDate.getDate());

        // new way

        LocalDate localDate=LocalDate.now();
        LocalTime localTime=LocalTime.now();
        LocalDateTime localDateTime=LocalDateTime.now();

        System.out.println("Local Date-->" +localDate);
        System.out.println("Local Time-->" +localTime);
        System.out.println("LocalDateTime-->" +localDateTime);

        ZonedDateTime time=ZonedDateTime.now();

        // some more methods in the Time Package

        System.out.println("local get year -->" +localDate.getYear());
        System.out.println("local get time-->" +localDate.getMonth());
        //System.out.println("Time Zone-->" +localTime.);

    }
}
