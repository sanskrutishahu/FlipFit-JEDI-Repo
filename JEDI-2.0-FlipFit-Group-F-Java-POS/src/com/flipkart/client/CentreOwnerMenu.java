package com.flipkart.client;
import java.util.*;


public class CentreOwnerMenu {

    public static void editProfile()
    {
        System.out.println("You are in Edit Profile function\n");
    }
    public static void addGym()
    {
        System.out.println("You are in add Gym function\n");
    }
    public static void removeGym()
    {
        System.out.println("You are in Remove Gym function\n");
    }
    public static void viewOwnerBookings()
    {
        System.out.println("You are in view Owner Bookings function\n");
    }
    public static void userLogout()
    {
        System.out.println("Logged out\n");
    }

    public static void main(String[] args){

        System.out.println("--------Welcome to FlipFit Centre Owner Menu Page--------");
        System.out.println("Enter preferred choices:\n1. Edit Profile\n2. Add Gym\n3. Remove Gym\n4. View Owner Bookings\n5. Log Out");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch(choice) {
            case 1:
                editProfile();
                break;
            case 2:
                addGym();
                break;
            case 3:
                removeGym();
                break;
            case 4:
                viewOwnerBookings();
                break;
            case 5:
                userLogout();
                break;
            default:
                System.out.println("Invalid choice");
        }
        in.close();
    }
}