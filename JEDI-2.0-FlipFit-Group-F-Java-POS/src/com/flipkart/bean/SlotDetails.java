package com.flipkart.bean;


public class SlotDetails {

	private int slotID;
	private int gymId;
	private String date;
	private String startTime;
	private String endTime;
	private int noOfSeats;

	public SlotDetails(int gymId, int slotID, String date, String startTime, int noOfSeats, String endTime) {
		this.gymId = gymId;
		this.slotID = slotID;
		this.date = date;
		this.startTime = startTime;
		this.noOfSeats = noOfSeats;
		this.endTime = endTime;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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
