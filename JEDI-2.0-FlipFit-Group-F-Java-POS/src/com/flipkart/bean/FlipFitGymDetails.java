package com.flipkart.bean;

public class FlipFitGymDetails {
	
    private int gymId;
    private int gymOwnerId;
    private String gymName;
    private String gymAddress;
    private int noOfSlots;
    private int approvalStatus;

    public FlipFitGymDetails(int gymId, int gymOwnerId, String gymName, String gymAddress, int noOfSlots, int approvalStatus) {
        this.gymId = gymId;
        this.gymOwnerId = gymOwnerId;
        this.gymName = gymName;
        this.gymAddress = gymAddress;
        this.noOfSlots = noOfSlots;
        this.approvalStatus = approvalStatus;
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

    public int getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(int approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
}
