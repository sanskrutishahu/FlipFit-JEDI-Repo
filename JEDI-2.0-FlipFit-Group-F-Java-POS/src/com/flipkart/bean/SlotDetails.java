package com.flipkart.bean;


public class SlotDetails {

	private int slotID;
	private int gymId;
	private String startTime;
	private String endTime;
	private int noOfSeats;

	public SlotDetails(int slotID, int gymId, String startTime, String endTime, int noOfSeats) {
		this.slotID = slotID;
		this.gymId = gymId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.noOfSeats = noOfSeats;
	}

	public int getSlotID() {
		return slotID;
	}

	public void setSlotID(int slotID) {
		this.slotID = slotID;
	}

	public int getGymId() {
		return gymId;
	}

	public void setGymId(int gymId) {
		this.gymId = gymId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
}
