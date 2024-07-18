package com.flipkart.bean;

public class FlipFitGymDetails {
	
    private int centerId;
    private int useId;
    private String centerName;
    private String centerAddress;
    private int noOfSlots;
    private int approvalStatus;

    public FlipFitGymDetails(int centerId, int centerOwnerId, String centerName, String address, int noOfSlots, int approvalStatus) {
        this.centerId = centerId;
        this.useId = centerOwnerId;
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

    public int getUseId() {
        return useId;
    }

    public void setUseId(int useId) {
        this.useId = useId;
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
