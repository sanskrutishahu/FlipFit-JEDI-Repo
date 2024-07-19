package com.flipkart.client;
import java.util.*;

import com.flipkart.business.FlipFitAdminInterface;
import com.flipkart.business.FlipFitAdminService;
import com.flipkart.bean.FlipFitAdmin;

public class FlipFitAdminMenu {
    FlipFitAdminInterface flipFitAdminService = new FlipFitAdminService();
    public  void viewPendingCentre()
    {

        System.out.println("You are in view View Pending Centre function\n");
        flipFitAdminService.viewPendingCenter();
        System.out.println("Pending Centres \n");
    }
    public  void viewPendingOwner()
    {
        System.out.println("You are in View Pending Owner function\n");
        flipFitAdminService.viewPendingOwner();
        System.out.println("Pending Owners \n");
    }
    public  void approveCentre(int gymId)
    {

        System.out.println("You are in Approve Centre function\n");
        flipFitAdminService.approveGymRequests(gymId);
        System.out.println(" Approved Centres \n");
    }
    public void approveOwner(int ownerId)
    {
        System.out.println("You are in Approve Owner function\n");
        flipFitAdminService.approveGymOwnerRequests(ownerId);
       System.out.println(" Approved Owners \n");

    }
    public void rejectCentre(int gymId)
    {
        System.out.println("You are in Reject Centre function\n");
        flipFitAdminService.rejectGymRequests(gymId);
        System.out.println("Rejected Centres \n");
    }
    public void rejectOwner(int ownerId)
    {

        System.out.println("You are in Reject Owner function\n");
        flipFitAdminService.rejectGymOwnerRequests(ownerId);
        System.out.println("Rejected Owners \n");
    }
    public void removeCentre(int GymId)
    {

        System.out.println("You are in Remove Centre function\n");
        flipFitAdminService.removeGym(GymId);
        System.out.println("Successfully Removed Centre \n");
    }
    public  void removeOwner(int ownerId)
    {

        System.out.println("You are in Remove Owner function\n");
        flipFitAdminService.removeGymOwner(ownerId);
        System.out.println("Successfully Removed Owner \n");
    }
    public  void viewAllGymOwners()
    {
        System.out.println("You are in View All Gym Owner function\n");
        flipFitAdminService.viewAllGymOwners();
        System.out.println("View All Gym Owner \n");

    }
    public  void viewGymOwnersDetails(int ownerId)
    {
        System.out.println("You are in View Gym Owner Details function\n");
        flipFitAdminService.viewGymOwnerDetails(ownerId);
        System.out.println("View Gym Owner Details \n");

    }
    public void userLogout()
    {

        System.out.println("Successfully Logged out\n");
    }
    public int TakeGymId()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Select Gym Id: \n");
        int gymId = in.nextInt();
        return gymId;
    }
    public int TakeGymOwnerId()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Select Gym Owner Id: \n");
        int ownerId = in.nextInt();
        return ownerId;
    }

    public static void login(String email, String password){

        System.out.println("--------Welcome to FlipFit Admin Menu Page--------");
        System.out.println("Enter preferred choices:\n1. View Pending Centre\n2. View Pending Owner\n3. Approve Centre\n4. Approve Owner\n5. Reject Centre\n6. Reject Owner\n7. Remove Centre\n8. Remove Owner \n9. View all Gym Owners \n10.View Gym Owner details \n11. Log Out");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        FlipFitAdminMenu menu = new FlipFitAdminMenu();
        int gymId;
        int ownerId;
        switch(choice) {
            case 1:
                menu.viewPendingCentre();
                break;
            case 2:
                menu.viewPendingOwner();
                break;
            case 3:
                gymId=menu.TakeGymId();
                menu.approveCentre(gymId);
                break;
            case 4:
                ownerId= menu.TakeGymOwnerId();
                menu.approveOwner(ownerId);
                break;
            case 5:
                gymId = menu.TakeGymId();
                menu.rejectCentre(gymId);
                break;
            case 6:
                ownerId=menu.TakeGymOwnerId();
                menu.rejectOwner(ownerId);
                break;
            case 7:
                gymId=menu.TakeGymId();
                menu.removeCentre(gymId);
                break;
            case 8:
                ownerId= menu.TakeGymOwnerId();
                menu.removeOwner(ownerId);
                break;
            case 9:
                menu.viewAllGymOwners();
                break;
            case 10:
                ownerId=menu.TakeGymOwnerId();
                menu.viewGymOwnersDetails(ownerId);
                break;
            case 11:
                menu.userLogout();
                break;
            default:
                System.out.println("Invalid choice");
        }
        in.close();
    }
}
