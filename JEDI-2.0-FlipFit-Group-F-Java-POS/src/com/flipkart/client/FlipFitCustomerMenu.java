package com.flipkart.client;
import com.flipkart.business.FlipFitGymBookingService;
import com.flipkart.bean.FlipFitCustomer;

import java.util.*;


public class FlipFitCustomerMenu {

    public static void viewCustomerBookings()
    {
        System.out.println("You are in View Bookings function\n");
    }
    public static void BookASlot()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("You are in Book A Slot function\n");
        System.out.println("Enter Slot ID: ");
        int slotID = Integer.parseInt(in.next());

    }
    public static void cancelBooking()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("You are in cancel Booking function\n");
        System.out.println("Enter Booking ID: ");
        int bookingId = Integer.parseInt(in.next());
    }
    public static void viewProfile()
    {
        System.out.println("You are in view Profile function\n");
    }
    public static void viewGymCenters() {System.out.println("You are in view Gym Centers function\n");}
    public static void viewAvailableSlots()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("You are in view Available Slots function\n");
        System.out.println("Enter Gym ID: ");
        int gymId = Integer.parseInt(in.next());
    }
    public static void editProfile()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("You are in Edit Profile function\n");
        System.out.println("Enter your Name: ");
        String customerName = in.next();
        System.out.println("Enter your Phone Number: ");
        String customerPhone = in.next();
        System.out.println("Enter your Age: ");
        int age = Integer.parseInt(in.next());
        System.out.println("Enter your Gender: ");
        String gender = in.next();
        System.out.println("Enter your Weight: ");
        int weight = Integer.parseInt(in.next());
        System.out.println("Enter your address: ");
        String customerAddress = in.next();
        FlipFitCustomer customer = new FlipFitCustomer(weight, age, gender, customerName, customerPhone, customerAddress, 0);
    }
    public static void userLogout()
    {
        System.out.println("Logged out\n");
    }

    public static void login(String email, String password){

        System.out.println("--------Welcome to FlipFit Customer Menu Page--------");
        System.out.println("Enter preferred choices:\n1. View Profile \n2. Edit Profile\n3. View Bookings\n4. View Gym Centers\n5. View Available Slots\n6. Book A Slot\n7. Cancel Booking\n8. Log Out");
        Scanner in = new Scanner(System.in);
        int id = 9;
        int choice = in.nextInt();
        switch(choice) {
            case 1:
                viewProfile();
                break;
            case 2:
                editProfile();
                break;
            case 3:
                viewCustomerBookings();
                break;
            case 4:
                viewGymCenters();
                break;
            case 5:
                viewAvailableSlots();
                break;
            case 6:
                BookASlot();
                break;
            case 7:
                cancelBooking();
                break;
            case 8:
                userLogout();
                break;
            default:
                System.out.println("Invalid choice");
        }
        in.close();
    }
}