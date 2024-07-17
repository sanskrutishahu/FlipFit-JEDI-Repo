package com.flipkart.bean;

public class CentreOwner {
	
	private int ownerId;
	private String ownerName;
	private int ownerContact;
	private int ownerAddress;
	private String ownerGstNum;
	private String ownerPanNum;
	private String approvalStatus;
	private int userId;

	public CentreOwner(int ownerId, String ownerName, int ownerContact, int ownerAddress, String ownerGstNum, String ownerPanNum, int userId, String approvalStatus) {
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.ownerContact = ownerContact;
		this.ownerAddress = ownerAddress;
		this.ownerGstNum = ownerGstNum;
		this.ownerPanNum = ownerPanNum;
		this.userId = userId;
		this.approvalStatus = approvalStatus;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getOwnerContact() {
		return ownerContact;
	}

	public void setOwnerContact(int ownerContact) {
		this.ownerContact = ownerContact;
	}

	public int getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(int ownerAddress) {
		this.ownerAddress = ownerAddress;
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
