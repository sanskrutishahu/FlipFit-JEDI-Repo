package com.flipkart.business;
import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.exceptions.GymOwnerNotFoundException;

import java.util.List;

/**
 * Interface for Admin Operation
 */
public interface FlipFitAdminInterface {

    /**
     * Method to Create a new Admin
     * @param customUserName : Name of admin
     * @param adminId
     */
    public void createAdmin(String customUserName, int adminId);

    /**
     * Method to view all Gym Owners
     */
    public void viewAllGymOwners();

    /**
     * Method to view all existing Gym details
     */
    public void viewGymDetails();

    /**
     * Method to approve gym owner requests
     * @param ownerId
     */
    public void approveGymOwnerRequests(int ownerId);

    /**
     * Method to approve gym requests
     * @param gymId
     */
    public void approveGymRequests(int gymId);

    /**
     * Method to reject Gym Owner Requests
     * @param ownerId
     */
    public void rejectGymOwnerRequests(int ownerId);

    /**
     * Method to reject Gym requests
     * @param gymId
     */
    public void rejectGymRequests(int gymId);

    /**
     * Method to remove Gym from  Gym Catalog
     * @param gymId
     */
    public void removeGym(int gymId);

    /**
     * Method to view pending requests of Gym Owners
     */
    public void viewPendingOwner();

    /**
     * Method to view pending requests of centers
     */
    public void viewPendingCenter();

    /**
     * Method to remove Gym Owners
     * @param ownerId
     */
    public void removeGymOwner(int ownerId);

//    public void cancelRequest(int ownerId);

}
