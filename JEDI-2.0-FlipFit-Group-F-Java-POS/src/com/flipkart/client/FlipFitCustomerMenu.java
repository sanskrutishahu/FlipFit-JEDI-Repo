package com.flipkart.client;
import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.business.FlipFitGymBookingService;
import com.flipkart.business.FlipFitCustomerService;

import java.util.*;


public class FlipFitCustomerMenu {

    public static void viewCustomerBookings(int id, FlipFitGymBookingService booking)
    {
        booking.viewBookings(id);
       if(booking.viewBookings(id)==null)
        {
            System.out.println("No Bookings Found!!");
            return;
        }
        for(Booking x : booking.viewBookings(id)) {
            System.out.println(x);
        }
    }

    public static void BookASlot(int id, FlipFitGymBookingService booking)
    {
        Scanner in = new Scanner(System.in);
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
        System.out.println(customer.viewProfile(id));
    }
    public static void viewGymCenters(FlipFitCustomerService customer)
    {
        if(customer.viewGyms()==null)
        {
            System.out.println("No Gym Centre Found!!");
            return;
        }
        for(FlipFitGymDetails x : customer.viewGyms()) {
            System.out.println(x);
        }
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
//    public static void editProfile(int id, FlipFitCustomerService customer)
//    {
//        Scanner in = new Scanner(System.in);
//        System.out.println("Enter your Name: ");
//        String customerName = in.next();
//        System.out.println("Enter your Phone Number: ");
//        String customerPhone = in.next();
//        System.out.println("Enter your Age: ");
//        int age = Integer.parseInt(in.next());
//        System.out.println("Enter your Gender: ");
//        String gender = in.next();
//        System.out.println("Enter your Weight: ");
//        int weight = Integer.parseInt(in.next());
//        System.out.println("Enter your address: ");
//        String customerAddress = in.next();
//        customer.editProfile(weight, age, gender, customerName, customerPhone, customerAddress, id);
//
//    }
    public static void userLogout()
    {
        System.out.println("Logged out\n");
    }

    public static void displayCustomerMenu()
    {
        System.out.println("--------Welcome to FlipFit Customer Menu Page--------");
        System.out.println("Enter preferred choices:\n1. View Profile \n2. View Bookings\n3. View Gym Centers\n4. View Available Slots\n5. Book A Slot\n6. Cancel Booking\n7. Log Out");
    }

    public static void login(int id){
        Scanner in = new Scanner(System.in);
        FlipFitCustomerMenu menu = new FlipFitCustomerMenu();
        int choice = 0;
        FlipFitCustomerService customer = new FlipFitCustomerService();
        FlipFitGymBookingService booking = new FlipFitGymBookingService();
        menu.displayCustomerMenu();
        while(choice != 7) {
            choice = in.nextInt();
            switch(choice) {
                case 1:
                    viewProfile(id, customer);
                    break;
//            case 2:
//                editProfile(id, customer);
//                break;
                case 2:
                    viewCustomerBookings(id, booking);
                    break;
                case 3:
                    viewGymCenters(customer);
                    break;
                case 4:
                    viewAvailableSlots(customer);
                    break;
                case 5:
                    BookASlot(id, booking);
                    break;
                case 6:
                    cancelBooking(booking);
                    break;
                case 7:
                    userLogout();
                    in.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println("Press 1 to go back to 'Customer Menu Page' OR any other key to 'Log Out'");
            int newChoice = in.nextInt();
            if (newChoice == 1) menu.displayCustomerMenu();
            else break;
        }
        in.close();
    }
}