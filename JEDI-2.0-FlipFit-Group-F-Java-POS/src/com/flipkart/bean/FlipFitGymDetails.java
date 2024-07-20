package com.flipkart.bean;

public class FlipFitGymDetails {
	
    private int gymId;
    private int gymOwnerId;
    private String gymName;
    private String gymAddress;
    private int noOfSlots;
    private String approvalStatus;

    public FlipFitGymDetails(int gymId, int gymOwnerId, String gymName, String gymAddress, int noOfSlots, String approvalStatus) {
        this.gymId = gymId;
        this.gymOwnerId = gymOwnerId;
        this.gymName = gymName;
        this.gymAddress = gymAddress;
        this.noOfSlots = noOfSlots;
        this.approvalStatus = approvalStatus;
    }

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

    public int getGymId() {
        return gymId;
    }

    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    public int getGymOwnerId() {
        return gymOwnerId;
    }

    public void setGymOwnerId(int gymOwnerId) {
        this.gymOwnerId = gymOwnerId;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public String getGymAddress() {
        return gymAddress;
    }

    public void setGymAddress(String gymAddress) {
        this.gymAddress = gymAddress;
    }

    public int getNoOfSlots() {
        return noOfSlots;
    }

    public void setNoOfSlots(int noOfSlots) {
        this.noOfSlots = noOfSlots;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
}
