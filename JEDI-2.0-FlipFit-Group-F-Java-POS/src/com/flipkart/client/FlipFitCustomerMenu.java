package com.flipkart.client;
import com.flipkart.bean.Booking;
import com.flipkart.business.FlipFitGymBookingService;
import com.flipkart.business.FlipFitCustomerService;

import java.util.*;


public class FlipFitCustomerMenu {

    public static void viewCustomerBookings(int id, FlipFitGymBookingService booking)
    {
        booking.viewBookings(id);
//        FlipFitGymBookingService service = new FlipFitGymBookingService();
//        for(Booking x: service.viewBookings(1)) {
//            System.out.println(x);
//        }
    }
    public static void BookASlot(int id, FlipFitGymBookingService booking)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("You are in Book A Slot function\n");
        System.out.println("Enter Slot ID: ");
        int slotID = Integer.parseInt(in.next());
        System.out.println("Enter Date (DD/MM/YYYY): ");
        String date = in.next();
        booking.bookSlots(0, id, slotID, date, "", "", 1, 1, 1);
    }
    public static void cancelBooking(FlipFitGymBookingService booking)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Booking ID: ");
        int bookingId = Integer.parseInt(in.next());
        booking.cancelBookings(bookingId);
    }
    public static void viewProfile(int id, FlipFitCustomerService customer)
    {
        customer.viewProfile(id);
//        FlipFitCustomerService service = new FlipFitCustomerService();
//        System.out.println(service.viewProfile(1));
    }
    public static void viewGymCenters(FlipFitCustomerService customer)
    {
        customer.viewGyms();
    }
    public static void viewAvailableSlots(FlipFitCustomerService customer)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Gym ID: ");
        int gymId = Integer.parseInt(in.next());
        System.out.println("Enter Date (DD/MM/YYYY): ");
        String date = in.next();
        customer.viewSlots(gymId, date);
    }
    public static void editProfile(int id, FlipFitCustomerService customer)
    {
        Scanner in = new Scanner(System.in);
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
        customer.editProfile(weight, age, gender, customerName, customerPhone, customerAddress, id);

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
        FlipFitCustomerService customer = new FlipFitCustomerService();
        FlipFitGymBookingService booking = new FlipFitGymBookingService();
        int choice = in.nextInt();
        switch(choice) {
            case 1:
                viewProfile(id, customer);
                break;
            case 2:
                editProfile(id, customer);
                break;
            case 3:
                viewCustomerBookings(id, booking);
                break;
            case 4:
                viewGymCenters(customer);
                break;
            case 5:
                viewAvailableSlots(customer);
                break;
            case 6:
                BookASlot(id, booking);
                break;
            case 7:
                cancelBooking(booking);
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