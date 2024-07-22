package com.flipkart.client;
import java.util.*;
import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.SlotDetails;
import com.flipkart.business.FlipFitGymOwnerService;
public class FlipFitGymOwnerMenu {
    FlipFitGymOwnerService flipFitGymOwnerService = new FlipFitGymOwnerService();
    Scanner scanner = new Scanner(System.in);
//    public  void editProfile()
//    {
//
//        System.out.println("You are in Edit Profile function\n");
//        System.out.println("Enter Owner Name: ");
//        String ownerName = scanner.nextLine();
//        System.out.println("Enter Owner Phone: ");
//        String ownerPhone = scanner.nextLine();
//        System.out.println("Enter Owner Address: ");
//        String ownerAddress = scanner.nextLine();
//        System.out.println("Enter Owner GST Number: ");
//        String ownerGstNum = scanner.nextLine();
//        System.out.println("Enter Owner PAN Number: ");
//        String ownerPanNum = scanner.nextLine();
//        System.out.println("Enter Owner ID: ");
//        int ownerId = scanner.nextInt();
//        scanner.nextLine();
//        flipFitGymOwnerService.editProfile(ownerName, ownerPhone, ownerAddress, ownerGstNum, ownerPanNum, ownerId);
//
//    }
    public  void addGym(int gymOwnerId)
    {
        System.out.println("Enter following details to get your Gym listed:");
//        System.out.println("Enter Gym Owner ID: ");
//        int gymOwnerId = scanner.nextInt();
//        scanner.nextLine(); // consume newline
        System.out.print("Enter Gym Name: \n");
        String gymName = scanner.nextLine();
        System.out.println("Enter Gym Address: ");
        String gymAddress = scanner.nextLine();
        flipFitGymOwnerService.registerGym(gymOwnerId, gymName, gymAddress);
    }
    public  void removeGym()
    {
        System.out.print("Enter ID of Gym to remove: \n");
        int gymId = scanner.nextInt();
        flipFitGymOwnerService.removeGym(gymId);
    }
//    public  void viewBookings()
//    {
//        System.out.println("You are in view Owner Bookings function\n");
//        System.out.print("Enter Owner ID: ");
//        int ownerId = scanner.nextInt();
//        flipFitGymOwnerService.viewAllBookings(ownerId);
//    }
//    public void editGym()
//    {
//        System.out.println("Enter Gym Owner ID: ");
//        int gymOwnerId = scanner.nextInt();
//        scanner.nextLine();
//        System.out.println("Enter Gym ID: ");
//        int gymId = scanner.nextInt();
//        System.out.println("Enter your preferred choice: \n1. Edit Gym name\n2. Edit Gym Address\n");
//        System.out.println("Enter Gym Name: ");
//        String gymName = scanner.nextLine();
//        System.out.println("Enter Gym Address: ");
//        String gymAddress = scanner.nextLine();
//        System.out.println("Enter Number of Slots: ");
//        int noOfSlots = scanner.nextInt();
//        flipFitGymOwnerService.editGym(gymId, gymOwnerId, gymName, gymAddress, noOfSlots);
//    }
    public void viewRegisteredGymCenters(int userId)
    {
//        System.out.println("You are in view Registered Gym centers function\n");
        flipFitGymOwnerService.viewAllRegisteredGymCenters(userId);
    }
//    public void viewGymBookings()
//    {
//        System.out.println("You are in view Gym bookings function\n");
//        System.out.print("Enter Gym ID: ");
//        int gymId = scanner.nextInt();
//
//        List<Booking> bookings = flipFitGymOwnerService.viewBookings(gymId);
//        for (Booking booking : bookings) {
//            System.out.println(booking);
//        }
//    }
    public void viewAvailableSlots()
    {
        System.out.print("Enter Gym ID: ");
        int gymId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Date: ");
        String date = scanner.nextLine();
        flipFitGymOwnerService.viewAvailableSlots(gymId, date);
    }
    public void addSlot()
    {
        System.out.println("Enter below details to add a new slot in the Gym:");
        System.out.print("Enter Gym ID: ");
        int gymId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Date (DD/MM/YYYY): ");
        String date= scanner.nextLine();
        System.out.print("Enter Start Time (HH:MM): ");
        String startTime = scanner.nextLine();
        System.out.print("Enter End Time (HH:MM): ");
        String endTime = scanner.nextLine();
        System.out.print("Enter Number of Seats: ");
        int noOfSeats = scanner.nextInt();
        flipFitGymOwnerService.addSlot(gymId,date,startTime,endTime,noOfSeats);
    }
    public void removeSlot()
    {
        System.out.println("Enter below details to remove slot from the Gym:");
        System.out.print("Enter Gym ID: ");
        int gymId = scanner.nextInt();
        System.out.print("Enter Slot ID: ");
        int slotId = scanner.nextInt();
        flipFitGymOwnerService.removeSlot(gymId,slotId);
    }
    public  void userLogout()
    {
        System.out.println("Logged out\n");
    }
    public void displayGymOwnerMenu()
    {
        System.out.println("-------- Welcome to FlipFit Owner Menu Page --------");
        System.out.println("Enter preferred choices:\n1. Add Gym\n2. Remove Gym\n3. View all my registered Gyms \n4. View all Available Slots \n5. Add Slots \n6. Remove Slots \n7. Log Out");
    }
    public static void login(int id){

        FlipFitGymOwnerMenu menu = new FlipFitGymOwnerMenu();
        Scanner in = new Scanner(System.in);

        menu.displayGymOwnerMenu();
        int choice = 0;
        while(choice != 8) {
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    menu.addGym(id);
                    break;
                case 2:
                    menu.removeGym();
                    break;
                case 3:
                    menu.viewRegisteredGymCenters(id);
                    break;
                case 4:
                    menu.viewAvailableSlots();
                    break;
                case 5:
                    menu.addSlot();
                    break;
                case 6:
                    menu.removeSlot();
                    break;
                case 7:
                    menu.userLogout();
                    in.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println("Press 1 to go back to 'Gym Owner Menu Page' OR any other key to 'Log Out'");
            int newChoice = in.nextInt();
            if(newChoice == 1) menu.displayGymOwnerMenu();
            else break;
        }
        in.close();
    }
}