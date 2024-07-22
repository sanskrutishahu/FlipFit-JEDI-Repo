package com.flipkart.bean;
/**
 * The FlipFitGymOwner class represents the details of a gym owner in the FlipFit system.
 * It includes details such as owner name, phone, address, GST number, PAN number, approval status, and owner ID.
 */
public class FlipFitGymOwner{

	private String ownerName;
	private String ownerPhone;
	private String ownerAddress;
	private String ownerGstNum;
	private String ownerPanNum;
	private String approvalStatus;
	private int ownerId;

	/**
	 * Constructor to initialize a FlipFitGymOwner object with all fields.
	 *
	 * @param ownerName      the name of the gym owner
	 * @param ownerPhone     the phone number of the gym owner
	 * @param ownerAddress   the address of the gym owner
	 * @param ownerGstNum    the GST number of the gym owner
	 * @param ownerPanNum    the PAN number of the gym owner
	 * @param approvalStatus the approval status of the gym owner
	 * @param ownerId        the unique identifier for the gym owner
	 */
	public FlipFitGymOwner(String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum, String approvalStatus, int ownerId) {
		this.ownerName = ownerName;
		this.ownerPhone = ownerPhone;
		this.ownerAddress = ownerAddress;
		this.ownerGstNum = ownerGstNum;
		this.ownerPanNum = ownerPanNum;
		this.approvalStatus = approvalStatus;
		this.ownerId = ownerId;
	}

	/**
	 * Returns a string representation of the gym owner details.
	 * The string includes all the details of the gym owner.
	 *
	 * @return a string representation of the gym owner details
	 */
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

	/**
	 * Gets the name of the gym owner.
	 *
	 * @return the gym owner's name
	 */
	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * Sets the name of the gym owner.
	 *
	 * @param ownerName the gym owner's name to set
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	/**
	 * Gets the phone number of the gym owner.
	 *
	 * @return the gym owner's phone number
	 */
	public String getOwnerPhone() {
		return ownerPhone;
	}

	/**
	 * Sets the phone number of the gym owner.
	 *
	 * @param ownerPhone the gym owner's phone number to set
	 */
	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}

	/**
	 * Gets the address of the gym owner.
	 *
	 * @return the gym owner's address
	 */
	public String getOwnerAddress() {
		return ownerAddress;
	}

	/**
	 * Sets the address of the gym owner.
	 *
	 * @param ownerAddress the gym owner's address to set
	 */
	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}

	/**
	 * Gets the GST number of the gym owner.
	 *
	 * @return the gym owner's GST number
	 */
	public String getOwnerGstNum() {
		return ownerGstNum;
	}

	/**
	 * Sets the GST number of the gym owner.
	 *
	 * @param ownerGstNum the gym owner's GST number to set
	 */
	public void setOwnerGstNum(String ownerGstNum) {
		this.ownerGstNum = ownerGstNum;
	}

	/**
	 * Gets the approval status of the gym owner.
	 *
	 * @return the gym owner's approval status
	 */
	public String getApprovalStatus() {
		return approvalStatus;
	}

	/**
	 * Sets the approval status of the gym owner.
	 *
	 * @param approvalStatus the gym owner's approval status to set
	 */
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	/**
	 * Gets the PAN number of the gym owner.
	 *
	 * @return the gym owner's PAN number
	 */
	public String getOwnerPanNum() {
		return ownerPanNum;
	}

	/**
	 * Sets the PAN number of the gym owner.
	 *
	 * @param ownerPanNum the gym owner's PAN number to set
	 */
	public void setOwnerPanNum(String ownerPanNum) {
		this.ownerPanNum = ownerPanNum;
	}

	/**
	 * Gets the unique identifier for the gym owner.
	 *
	 * @return the gym owner's ID
	 */
	public int getOwnerId() {
		return ownerId;
	}

	/**
	 * Sets the unique identifier for the gym owner.
	 *
	 * @param ownerId the gym owner's ID to set
	 */
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
}
