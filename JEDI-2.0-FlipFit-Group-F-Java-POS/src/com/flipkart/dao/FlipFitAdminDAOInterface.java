package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymDetails;
import com.flipkart.bean.FlipFitGymOwner;
import java.util.List;

/**
 * Interface representing data access operations for FlipFit admin functionalities.
 */
public interface FlipFitAdminDAOInterface {

    /**
     * Creates an admin with the given custom username and admin ID.
     *
     * @param customUserName The custom username of the admin to be created.
     * @param adminId        The admin ID of the admin to be created.
     */
    public void createAdmin(String customUserName, int adminId);

    /**
     * Retrieves a list of all gym owners.
     *
     * @return List of FlipFitGymOwner objects representing all gym owners.
     */
    public List<FlipFitGymOwner> viewAllGymOwners();

    /**
     * Retrieves details of all gym centers.
     *
     * @return List of FlipFitGymDetails objects representing gym center details.
     */
    public List<FlipFitGymDetails> viewGymDetails();

    /**
     * Retrieves a list of gym owner requests pending for approval.
     *
     * @return List of FlipFitGymOwner objects representing pending gym owner requests.
     */
    public List<FlipFitGymOwner> viewGymOwnerRequests();

    /**
     * Approves a pending gym owner request identified by the owner ID.
     *
     * @param ownerId The ID of the gym owner request to be approved.
     * @return true if the approval was successful, false otherwise.
     */
    public boolean approveGymOwnerRequests(int ownerId);

    /**
     * Approves a pending gym request identified by the gym ID.
     *
     * @param gymId The ID of the gym request to be approved.
     * @return true if the approval was successful, false otherwise.
     */
    public boolean approveGymRequests(int gymId);

    /**
     * Rejects a pending gym owner request identified by the owner ID.
     *
     * @param ownerId The ID of the gym owner request to be rejected.
     * @return true if the rejection was successful, false otherwise.
     */
    public boolean rejectGymOwnerRequests(int ownerId);


    /**
     * Removes an approved gym identified by the gym ID.
     *
     * @param gymId The ID of the gym to be removed.
     * @return true if the removal was successful, false otherwise.
     */
    public boolean removeGym(int gymId);

    /**
     * Retrieves a list of pending gym owner requests.
     *
     * @return List of FlipFitGymOwner objects representing pending gym owner requests.
     */
    public List<FlipFitGymOwner> viewPendingOwner();

    /**
     * Retrieves a list of pending gym center requests.
     *
     * @return List of FlipFitGymDetails objects representing pending gym center requests.
     */
    public List<FlipFitGymDetails> viewPendingCenter();

    /**
     * Rejects a pending gym request identified by the gym ID.
     *
     * @param gymId The ID of the gym request to be rejected.
     * @return true if the rejection was successful, false otherwise.
     */
    public boolean rejectGymRequests(int gymId);

    /**
     * Removes an approved gym owner identified by the owner ID.
     *
     * @param ownerId The ID of the gym owner to be removed.
     * @return true if the removal was successful, false otherwise.
     */
    public boolean removeGymOwner(int ownerId);

}