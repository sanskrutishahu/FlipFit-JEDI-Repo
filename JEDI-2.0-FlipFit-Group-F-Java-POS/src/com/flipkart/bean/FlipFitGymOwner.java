package com.flipkart.bean;

public class FlipFitGymOwner{

	private String ownerName;
	private String ownerPhone;
	private String ownerAddress;
	private String ownerGstNum;
	private String ownerPanNum;
	private String approvalStatus;
	private int ownerId;

	public FlipFitGymOwner(String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum, String approvalStatus, int ownerId) {
		this.ownerName = ownerName;
		this.ownerPhone = ownerPhone;
		this.ownerAddress = ownerAddress;
		this.ownerGstNum = ownerGstNum;
		this.ownerPanNum = ownerPanNum;
		this.approvalStatus = approvalStatus;
		this.ownerId = ownerId;
	}

	@Override
	public String toString() {
		return
				"Owner Name: '" + ownerName + '\'' +"\n"+
				"Owner Phone: '" + ownerPhone + '\'' +"\n"+
				"Owner Address: '" + ownerAddress + '\'' +"\n"+
				"Owner GstNum: '" + ownerGstNum + '\'' +"\n"+
				"Owner PanNum: '" + ownerPanNum + '\'' +"\n"+
				"Approval Status: '" + approvalStatus + '\'' +"\n"+
				"Owner Id: " + ownerId +"\n"+
				"-----------------------------------";
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerPhone() {
		return ownerPhone;
	}

	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}

	public String getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}

	public String getOwnerGstNum() {
		return ownerGstNum;
	}

	public void setOwnerGstNum(String ownerGstNum) {
		this.ownerGstNum = ownerGstNum;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getOwnerPanNum() {
		return ownerPanNum;
	}

	public void setOwnerPanNum(String ownerPanNum) {
		this.ownerPanNum = ownerPanNum;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
}
