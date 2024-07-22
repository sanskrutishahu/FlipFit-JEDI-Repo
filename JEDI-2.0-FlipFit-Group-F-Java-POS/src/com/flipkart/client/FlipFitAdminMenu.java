package com.flipkart.client;
import java.util.*;

import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.business.FlipFitAdminInterface;
import com.flipkart.business.FlipFitAdminService;
import com.flipkart.bean.FlipFitAdmin;

public class FlipFitAdminMenu {
    FlipFitAdminInterface flipFitAdminService = new FlipFitAdminService();
    public  void viewPendingCentre()
    {
        flipFitAdminService.viewPendingCenter();
    }
    public  void viewPendingOwner()
    {
        flipFitAdminService.viewPendingOwner();
    }
    public  void approveCentre(int gymId)
    {
        flipFitAdminService.approveGymRequests(gymId);
    }
    public void approveOwner(int ownerId)
    {
        flipFitAdminService.approveGymOwnerRequests(ownerId);
    }
    public void rejectCentre(int gymId)
    {
        flipFitAdminService.rejectGymRequests(gymId);
    }
    public void rejectOwner(int ownerId)
    {
        flipFitAdminService.rejectGymOwnerRequests(ownerId);
    }
    public void removeCentre(int GymId)
    {
        flipFitAdminService.removeGym(GymId);
    }
    public  void removeOwner(int ownerId)
    {
        flipFitAdminService.removeGymOwner(ownerId);
    }
    public  void viewAllGymOwners()
    {
        flipFitAdminService.viewAllGymOwners();
    }
    public  void viewGymDetails()
    {
        flipFitAdminService.viewGymDetails();
    }
    public void userLogout()
    {
        System.out.println("Logged out\n");
    }
    public int TakeGymId()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Select Gym Id: ");
        int gymId = in.nextInt();
        return gymId;
    }
    public int TakeGymOwnerId()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Select Gym Owner Id: ");
        int ownerId = in.nextInt();
        return ownerId;
    }

    public void displayAdminMenu()
    {
        System.out.println("-------- Welcome to FlipFit Admin Menu Page --------");
        System.out.println("Enter preferred choices:\n1. View all Pending Gym Centre requests\n2. View all Pending Gym Owner requests\n3. Approve Gym Centre request\n4. Approve Gym Owner request\n5. Reject Gym Centre request\n6. Reject Gym Owner request\n7. View all Gym Owners \n8. View all Gym Centres \n9. Remove Gym Centre \n10.Remove Gym Owner \n11.Log Out");
    }

    public static void login(int userId){

        Scanner in = new Scanner(System.in);
        FlipFitAdminMenu menu = new FlipFitAdminMenu();
        int gymId;
        int ownerId;
        int choice = 0;
        menu.displayAdminMenu();
        while(choice != 11){
            choice = in.nextInt();
            switch(choice) {
                case 1:
                    menu.viewPendingCentre();
                    break;
                case 2:
                    menu.viewPendingOwner();
                    break;
                case 3:
                    gymId = menu.TakeGymId();
                    menu.approveCentre(gymId);
                    break;
                case 4:
                    ownerId = menu.TakeGymOwnerId();
                    menu.approveOwner(ownerId);
                    break;
                case 5:
                    gymId = menu.TakeGymId();
                    menu.rejectCentre(gymId);
                    break;
                case 6:
                    ownerId = menu.TakeGymOwnerId();
                    menu.rejectOwner(ownerId);
                    break;
                case 7:
                    menu.viewAllGymOwners();
                    break;
                case 8:
                    menu.viewGymDetails();
                    break;
                case 9:
                    gymId = menu.TakeGymId();
                    menu.removeCentre(gymId);
                    break;
                case 10:
                    ownerId = menu.TakeGymOwnerId();
                    menu.removeOwner(ownerId);
                    break;
                case 11:
                    menu.userLogout();
                    in.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println("Press 1 to go back to 'Admin Menu Page' OR any other key to 'Log Out'");
            int newChoice = in.nextInt();
            if(newChoice == 1) menu.displayAdminMenu();
            else break;
        }
        in.close();
    }
}
