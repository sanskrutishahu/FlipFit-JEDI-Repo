package com.flipkart.bean;

public class GymDetails {
	
    private int centerId;
    private int centerOwnerId;
    private String centerName;
    private String centerAddress;
    private int noOfSlots;
    private int approvalStatus;

    public GymDetails(int centerId, int centerOwnerId, String centerName, String address, int noOfSlots, int approvalStatus) {
        this.centerId = centerId;
        this.centerOwnerId = centerOwnerId;
        this.centerName = centerName;
        this.centerAddress = address;
        this.noOfSlots = noOfSlots;
        this.approvalStatus = approvalStatus;
    }

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public int getCenterOwnerId() {
        return centerOwnerId;
    }

    public void setCenterOwnerId(int centerOwnerId) {
        this.centerOwnerId = centerOwnerId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterAddress() {
        return centerAddress;
    }

    public void setCenterAddress(String centerAddress) {
        this.centerAddress = centerAddress;
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
