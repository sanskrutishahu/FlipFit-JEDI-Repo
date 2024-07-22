package com.flipkart.bean;
/**
 * The FlipFitGymDetails class represents the details of a gym in the FlipFit system.
 * It includes details such as gym ID, owner ID, name, address, number of slots, and approval status.
 */

public class FlipFitGymDetails {
	
    private int gymId;
    private int gymOwnerId;
    private String gymName;
    private String gymAddress;
    private int noOfSlots;
    private String approvalStatus;
    /**
     * Constructor to initialize a FlipFitGymDetails object with all fields.
     *
     * @param gymId          the unique identifier for the gym
     * @param gymOwnerId     the unique identifier for the gym owner
     * @param gymName        the name of the gym
     * @param gymAddress     the address of the gym
     * @param noOfSlots      the number of slots available in the gym
     * @param approvalStatus the approval status of the gym
     */
    public FlipFitGymDetails(int gymId, int gymOwnerId, String gymName, String gymAddress, int noOfSlots, String approvalStatus) {
        this.gymId = gymId;
        this.gymOwnerId = gymOwnerId;
        this.gymName = gymName;
        this.gymAddress = gymAddress;
        this.noOfSlots = noOfSlots;
        this.approvalStatus = approvalStatus;
    }

    /**
     * Returns a string representation of the gym details.
     * The string includes all the details of the gym.
     *
     * @return a string representation of the gym details
     */
    @Override
    public String toString() {
        return
                "Gym Id: " + gymId + "\n" +
                "Gym Owner Id: " + gymOwnerId + "\n" +
                "Gym Name: '" + gymName + '\'' + "\n" +
                "Gym Address: '" + gymAddress + '\'' + "\n" +
//                "No Of Slots: " + noOfSlots + "\n" +
//                "Approval Status: " + approvalStatus + "\n" +
                "-----------------------------------\n";
    }
    /**
     * Gets the unique identifier for the gym.
     *
     * @return the gym ID
     */
    public int getGymId() {
        return gymId;
    }

    /**
     * Sets the unique identifier for the gym.
     *
     * @param gymId the gym ID to set
     */
    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    /**
     * Gets the unique identifier for the gym owner.
     *
     * @return the gym owner ID
     */
    public int getGymOwnerId() {
        return gymOwnerId;
    }

    /**
     * Sets the unique identifier for the gym owner.
     *
     * @param gymOwnerId the gym owner ID to set
     */
    public void setGymOwnerId(int gymOwnerId) {
        this.gymOwnerId = gymOwnerId;
    }

    /**
     * Gets the name of the gym.
     *
     * @return the gym name
     */
    public String getGymName() {
        return gymName;
    }

    /**
     * Sets the name of the gym.
     *
     * @param gymName the gym name to set
     */
    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    /**
     * Gets the address of the gym.
     *
     * @return the gym address
     */
    public String getGymAddress() {
        return gymAddress;
    }

    /**
     * Sets the address of the gym.
     *
     * @param gymAddress the gym address to set
     */
    public void setGymAddress(String gymAddress) {
        this.gymAddress = gymAddress;
    }

    /**
     * Gets the number of slots available in the gym.
     *
     * @return the number of slots
     */
    public int getNoOfSlots() {
        return noOfSlots;
    }

    /**
     * Sets the number of slots available in the gym.
     *
     * @param noOfSlots the number of slots to set
     */
    public void setNoOfSlots(int noOfSlots) {
        this.noOfSlots = noOfSlots;
    }

    /**
     * Gets the approval status of the gym.
     *
     * @return the approval status
     */
    public String getApprovalStatus() {
        return approvalStatus;
    }

    /**
     * Sets the approval status of the gym.
     *
     * @param approvalStatus the approval status to set
     */
    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
}
