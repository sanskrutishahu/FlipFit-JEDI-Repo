package com.flipkart.bean;

public class FlipFitGymOwner {
	private String ownerGstNum;
	private String ownerPanNum;
	private String approvalStatus;
	private int userId;

	public FlipFitGymOwner(String ownerGstNum, String ownerPanNum, String approvalStatus, int userId) {
		this.ownerGstNum = ownerGstNum;
		this.ownerPanNum = ownerPanNum;
		this.approvalStatus = approvalStatus;
		this.userId = userId;
	}

	public String getOwnerGstNum() {
		return ownerGstNum;
	}

	public void setOwnerGstNum(String ownerGstNum) {
		this.ownerGstNum = ownerGstNum;
	}

	public String getOwnerPanNum() {
		return ownerPanNum;
	}

	public void setOwnerPanNum(String ownerPanNum) {
		this.ownerPanNum = ownerPanNum;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
