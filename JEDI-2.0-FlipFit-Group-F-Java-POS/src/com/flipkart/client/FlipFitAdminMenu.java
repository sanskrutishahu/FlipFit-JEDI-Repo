package com.flipkart.client;
import java.util.*;

import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.business.FlipFitAdminInterface;
import com.flipkart.business.FlipFitAdminService;
import com.flipkart.bean.FlipFitAdmin;
/**
 * A client class that simulates an admin menu for managing gym centres and owners in the FlipFit application.
 */
public class FlipFitAdminMenu {
    // Interface for admin operations
    FlipFitAdminInterface flipFitAdminService = new FlipFitAdminService();

    /**
     * Views all pending gym centre requests.
     */
    public  void viewPendingCentre()
    {
        flipFitAdminService.viewPendingCenter();
    }

    /**
     * Views all pending gym owner requests.
     */
    public  void viewPendingOwner()
    {

        flipFitAdminService.viewPendingOwner();
    }

    /**
     * Approves a gym centre request by gym ID.
     *
     * @param gymId The ID of the gym to approve.
     */
    public  void approveCentre(int gymId)
    {
        flipFitAdminService.approveGymRequests(gymId);
    }

    /**
     * Approves a gym owner request by owner ID.
     *
     * @param ownerId The ID of the gym owner to approve.
     */
    public void approveOwner(int ownerId)
    {
        flipFitAdminService.approveGymOwnerRequests(ownerId);
    }

    /**
     * Rejects a gym centre request by gym ID.
     *
     * @param gymId The ID of the gym to reject.
     */
    public void rejectCentre(int gymId)
    {
        flipFitAdminService.rejectGymRequests(gymId);
    }

    /**
     * Rejects a gym owner request by owner ID.
     *
     * @param ownerId The ID of the gym owner to reject.
     */
    public void rejectOwner(int ownerId)
    {
        flipFitAdminService.rejectGymOwnerRequests(ownerId);
    }

    /**
     * Removes a gym centre by gym ID.
     *
     * @param gymId The ID of the gym to remove.
     */
    public void removeCentre(int GymId)
    {
        flipFitAdminService.removeGym(GymId);
    }

    /**
     * Removes a gym owner by owner ID.
     *
     * @param ownerId The ID of the gym owner to remove.
     */
    public  void removeOwner(int ownerId)
    {
        flipFitAdminService.removeGymOwner(ownerId);
    }

    /**
     * Views all gym owners.
     */
    public  void viewAllGymOwners()
    {
        flipFitAdminService.viewAllGymOwners();
    }

    /**
     * Views details of all gym centres.
     */
    public  void viewGymDetails()
    {
        flipFitAdminService.viewGymDetails();
    }

    /**
     * Logs out the admin user.
     */
    public void userLogout()
    {
        System.out.println("Logged out\n");
    }

    /**
     * Takes the gym ID input from the admin.
     *
     * @return The gym ID entered by the admin.
     */
    public int TakeGymId()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Select Gym Id: ");
        int gymId = in.nextInt();
        return gymId;
    }


    /**
     * Takes the gym owner ID input from the admin.
     *
     * @return The gym owner ID entered by the admin.
     */
    public int TakeGymOwnerId()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Select Gym Owner Id: ");
        int ownerId = in.nextInt();
        return ownerId;
    }


    /**
     * Displays the admin menu.
     */
    public void displayAdminMenu()
    {
        System.out.println("-------- Welcome to FlipFit Admin Menu Page --------");
        System.out.println("Enter preferred choices:\n1. View all Pending Gym Centre requests\n2. View all Pending Gym Owner requests\n3. Approve Gym Centre request\n4. Approve Gym Owner request\n5. Reject Gym Centre request\n6. Reject Gym Owner request\n7. View all Gym Owners \n8. View all Gym Centres \n9. Remove Gym Centre \n10.Remove Gym Owner \n11.Log Out");
    }

    /**
     * Handles admin login and menu selection.
     *
     * @param userId The user ID of the admin.
     */
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
