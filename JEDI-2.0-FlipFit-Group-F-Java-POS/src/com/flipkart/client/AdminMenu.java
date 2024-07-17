package com.flipkart.client;
import java.util.*;


public class AdminMenu {

    public static void viewPendingCentre()
    {
        System.out.println("You are in view View Pending Centre function\n");
    }
    public static void viewPendingOwner()
    {
        System.out.println("You are in View Pending Owner function\n");
    }
    public static void approveCentre()
    {
        System.out.println("You are in Approve Centre function\n");
    }
    public static void approveOwner()
    {
        System.out.println("You are in Approve Owner function\n");
    }
    public static void rejectCentre()
    {
        System.out.println("You are in Reject Centre function\n");
    }
    public static void rejectOwner()
    {
        System.out.println("You are in Reject Owner function\n");
    }
    public static void removeCentre()
    {
        System.out.println("You are in Remove Centre function\n");
    }
    public static void removeOwner()
    {
        System.out.println("You are in Remove Owner function\n");
    }
    public static void userLogout()
    {
        System.out.println("Logged out\n");
    }

    public static void main(String[] args){

        System.out.println("--------Welcome to FlipFit Admin Menu Page--------");
        System.out.println("Enter preferred choices:\n1. View Pending Centre\n2. View Pending Owner\n3. Approve Centre\n4. Approve Owner\n5. Reject Centre\n6. Reject Owner\n7. Remove Centre\n8. Remove Owner\n9. Log Out");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch(choice) {
            case 1:
                viewPendingCentre();
                break;
            case 2:
                viewPendingOwner();
                break;
            case 3:
                approveCentre();
                break;
            case 4:
                approveOwner();
                break;
            case 5:
                rejectCentre();
                break;
            case 6:
                rejectOwner();
                break;
            case 7:
                removeCentre();
                break;
            case 8:
                removeOwner();
                break;
            case 9:
                userLogout();
                break;
            default:
                System.out.println("Invalid choice");
        }
        in.close();
    }
}