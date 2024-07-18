package com.flipkart.client;
import com.flipkart.bean.Booking;
import com.flipkart.business.FlipFitCustomerService;
import com.flipkart.business.FlipFitGymBookingService;

import java.util.*;


public class FlipFitCustomerMenu {

    public static void viewCustomerBookings()
    {
        System.out.println("Your are in view customer bookings section\n");
//        FlipFitGymBookingService service = new FlipFitGymBookingService();
//        for(Booking booking: service.viewBookings(1)) {
//            System.out.println(booking);
//        }
    }
    public static void addBooking()
    {
        System.out.println("You are in add Bookings function\n");
    }
    public static void cancelBooking()
    {
        System.out.println("You are in cancel Booking function\n");
    }
    public static void viewProfile()
    {
//        System.out.println("You are in view Profile function\n");
        FlipFitCustomerService service = new FlipFitCustomerService();
        System.out.println(service.viewProfile(1));
    }
    public static void viewCenters()
    {
        System.out.println("You are in view Centers function\n");
    }
    public static void editProfile()
    {
        System.out.println("You are in Edit Profile function\n");
    }
    public static void userLogout()
    {
        System.out.println("Logged out\n");
    }

    public static void main(String[] args){

        System.out.println("--------Welcome to FlipFit Customer Menu Page--------");
        System.out.println("Enter preferred choices:\n1. View Customer Booking\n2. Add Booking\n3. Cancel Booking\n4. View Profile\n5. View Centers\n6. Edit Profile\n7. Log Out");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch(choice) {
            case 1:
                viewCustomerBookings();
                break;
            case 2:
                addBooking();
                break;
            case 3:
                cancelBooking();
                break;
            case 4:
                viewProfile();
                break;
            case 5:
                viewCenters();
                break;
            case 6:
                editProfile();
                break;
            case 7:
                userLogout();
                break;
            default:
                System.out.println("Invalid choice");
        }
        in.close();
    }
}