package com.flipkart.bean;

public class FlipFitGymOwner extends User{
	private String ownerGstNum;
	private String ownerPanNum;
	private String approvalStatus;

	public FlipFitGymOwner(int userId, int roleId, String userPhoneNumber, String userAddress, String userEmail,
						   String userPassword, String userName,String ownerGstNum, String ownerPanNum, String approvalStatus) {
		super(userId, roleId, userPhoneNumber, userAddress, userEmail, userPassword, userName);
		this.ownerGstNum = ownerGstNum;
		this.ownerPanNum = ownerPanNum;
		this.approvalStatus = approvalStatus;
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

}
