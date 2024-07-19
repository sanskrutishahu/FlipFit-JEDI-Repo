package com.flipkart.client;
import java.util.*;
import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.SlotDetails;
import com.flipkart.business.FlipFitGymOwnerService;
public class FlipFitGymOwnerMenu {
    FlipFitGymOwnerService flipFitGymOwnerService = new FlipFitGymOwnerService();
    Scanner scanner = new Scanner(System.in);
    public  void editProfile()
    {

        System.out.println("You are in Edit Profile function\n");
        System.out.println("Enter Owner Name: ");
        String ownerName = scanner.nextLine();
        System.out.println("Enter Owner Phone: ");
        String ownerPhone = scanner.nextLine();
        System.out.println("Enter Owner Address: ");
        String ownerAddress = scanner.nextLine();
        System.out.println("Enter Owner GST Number: ");
        String ownerGstNum = scanner.nextLine();
        System.out.println("Enter Owner PAN Number: ");
        String ownerPanNum = scanner.nextLine();
        System.out.println("Enter Owner ID: ");
        int ownerId = scanner.nextInt();
        scanner.nextLine();
        flipFitGymOwnerService.editProfile(ownerName, ownerPhone, ownerAddress, ownerGstNum, ownerPanNum, ownerId);
        System.out.println("Edit Profile Successfully\n");

    }
    public  void addGym()
    {
        System.out.println("You are in add Gym function\n");
        System.out.println("Enter Gym ID: ");
        int gymId = scanner.nextInt();
        System.out.println("Enter Gym Owner ID: ");
        int gymOwnerId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Gym Name: ");
        String gymName = scanner.nextLine();
        System.out.println("Enter Gym Address: ");
        String gymAddress = scanner.nextLine();
        System.out.println("Enter Number of Slots: ");
        int noOfSlots = scanner.nextInt();
        flipFitGymOwnerService.registerGym(gymId, gymOwnerId, gymName, gymAddress, noOfSlots);
        System.out.println("Gym Added Successfully\n");

    }
    public  void removeGym()
    {

        System.out.println("You are in Remove Gym function\n");
        System.out.print("Enter Gym ID: ");
        int gymId = scanner.nextInt();
        flipFitGymOwnerService.removeGym(gymId);
        System.out.println("Gym Removed Successfully\n");
    }
    public  void viewBookings()
    {
        System.out.println("You are in view Owner Bookings function\n");
        System.out.print("Enter Owner ID: ");
        int ownerId = scanner.nextInt();
        flipFitGymOwnerService.viewAllBookings(ownerId);
        System.out.println("Owner Bookings View Successfully\n");
    }
    public void editGym()
    {
        System.out.println("You are in Edit Gym function\n");
        System.out.println("Enter Gym ID: ");
        int gymId = scanner.nextInt();
        System.out.println("Enter Gym Owner ID: ");
        int gymOwnerId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Gym Name: ");
        String gymName = scanner.nextLine();
        System.out.println("Enter Gym Address: ");
        String gymAddress = scanner.nextLine();
        System.out.println("Enter Number of Slots: ");
        int noOfSlots = scanner.nextInt();
        flipFitGymOwnerService.editGym(gymId, gymOwnerId, gymName, gymAddress, noOfSlots);
        System.out.println("Gym Edited Successfully\n");
    }
    public void viewRegisteredGymCenters()
    {
        System.out.println("You are in view Registered Gym centers function\n");
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        List<FlipFitGymDetails> gyms = flipFitGymOwnerService.viewAllRegisteredGymCenters(userId);
        for (FlipFitGymDetails gym : gyms) {
            System.out.println(gym);

        }
        System.out.println("Viewed Register Gym \n");
    }
    public void viewGymBookings()
    {
        System.out.println("You are in view Gym bookings function\n");
        System.out.print("Enter Gym ID: ");
        int gymId = scanner.nextInt();

        List<Booking> bookings = flipFitGymOwnerService.viewBookings(gymId);
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
        System.out.println("Viewed Gym Booking \n");
    }
    public void viewAvailableSlots()
    {
        System.out.println("You are in view Available slots function\n");
        System.out.print("Enter Gym ID: ");
        int gymId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Date: ");
        String date = scanner.nextLine();
        HashMap<String, Integer> slots = flipFitGymOwnerService.viewAvailableSlots(gymId, date);
        if (slots != null) {
            for (Map.Entry<String, Integer> entry : slots.entrySet()) {
                System.out.println("Time Slot: " + entry.getKey() + ", Availability: " + entry.getValue());
            }
        } else {
            System.out.println("No slots available for the given date.");
        }
        System.out.println("Viewed Available Slot \n");

    }
    public void addSlot()
    {
        System.out.println("You are in add slot function\n");
        System.out.print("Enter Slot ID: ");
        int slotID = scanner.nextInt();
        System.out.print("Enter Gym ID: ");
        int gymId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Start Time (HH:MM): ");
        String startTime = scanner.nextLine();
        System.out.print("Enter End Time (HH:MM): ");
        String endTime = scanner.nextLine();
        System.out.print("Enter Number of Seats: ");
        int noOfSeats = scanner.nextInt();
        System.out.print("Enter Date: ");
        String date= scanner.nextLine();
        SlotDetails slotDetails= new SlotDetails(gymId, slotID,date,startTime, noOfSeats,endTime);
        flipFitGymOwnerService.addSlot(slotDetails);
        System.out.println("Slot Added Successfully\n");
    }
    public void removeSlot()
    {
        System.out.println("You are in Remove slot function\n");
        System.out.print("Enter Gym ID: ");
        int gymId = scanner.nextInt();
        System.out.print("Enter Slot ID: ");
        int slotId = scanner.nextInt();

        flipFitGymOwnerService.removeSlot(gymId,slotId);
        System.out.println("Slot Removed Successfully\n");
    }
    public  void userLogout()
    {
        System.out.println("User Logged out Successfully\n");
    }
    public static void login(String email, String password){

        System.out.println("--------Welcome to FlipFit Owner Menu Page--------");
        System.out.println("Enter preferred choices:\n1. Edit Profile\n2. Add Gym\n3. Remove Gym\n4. View Bookings\n5. Edit Gym \n6. View Registered Gym Centers \n7. View Gym Booking \n8. View Available Slots \n9. Add Slots \n10. Remove Slots\n11. Log Out");
        FlipFitGymOwnerMenu menu = new FlipFitGymOwnerMenu();
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();

        switch(choice) {
            case 1:
                menu.editProfile();
                break;
            case 2:
                menu.addGym();
                break;
            case 3:
                menu.removeGym();
                break;
            case 4:
                menu.viewBookings();
                break;
            case 5:
                menu.editGym();
                break;
            case 6:
                menu.viewRegisteredGymCenters();
                break;
            case 7:
               menu.viewGymBookings();
                break;
            case 8:
                menu.viewAvailableSlots();
                break;
            case 9:
                menu.addSlot();
                break;
            case 10:
                menu.removeSlot();
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