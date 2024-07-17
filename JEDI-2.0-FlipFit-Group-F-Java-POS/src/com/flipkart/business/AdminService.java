package com.flipkart.business;
import com.flipkart.bean.GymOwner;

import java.util.List;

public class AdminService implements AdminInterface {

    public void createAdmin(int adminId, int userId, String userEmail, String userPass) {
        System.out.println("Admin created");
        // Actual implementation may involve storing admin details in the database via adminDAO
    }

    public List<GymOwner> viewAllGymOwners() {
        return null;
    }

    public List<GymOwner> viewGymOwnerDetails(int ownerId) {
        return null;
    }

    public List<GymOwner> viewGymOwnerRequests() {
        return null;
    }


    public void approveGymOwnerRequests(int ownerId) {
        System.out.println("Approved the gym owner requests with Id " + ownerId);
    }

    public void approveGymRequests(int gymId) {

    }

    public void rejectGymOwnerRequests(int ownerId) {

    }

    public void rejectGymRequests(int ownerId) {

    }

    public void removeGym(int ownerId) {

    }

    public void viewPendingOwner(int ownerId) {

    }

    public void viewPendingCenter(int ownerId) {

    }

    public void removeGymOwner(int ownerId) {
        System.out.println("Removed the gym owner with Id " + ownerId);
    }

    public void cancelRequest() {
        System.out.println("Removed the request ");

    }

    public void cancelRequest(int ownerId) {
        System.out.println("Cancelled the gym owner request with Id " + ownerId);
    }
}
