package com.flipkart.bean;


public class SlotDetails {
	private int slotID;
	private int gymId;
	private String date;
	private String startTime;
	private String endTime;
	private int noOfSeats;
	private int seatsLeft;
	private int slotBookingCost;

	public SlotDetails(int gymId, int slotID, String date, String startTime, String endTime, int noOfSeats, int seatsLeft, int slotBookingCost) {
		this.gymId = gymId;
		this.slotID = slotID;
		this.date = date;
		this.startTime = startTime;
		this.noOfSeats = noOfSeats;
		this.endTime = endTime;
		this.seatsLeft = seatsLeft;
		this.slotBookingCost = slotBookingCost;
	}

	@Override
	public String toString() {
		return
			"Gym Id: " + gymId +"\n"+
			"Slot Id: " + slotID +"\n"+
			"Date: " + date +"\n"+
			"Start Time: " + startTime  +"\n"+
			"End Time: " + endTime +"\n"+
			"Available Seats: " + noOfSeats +"\n"+
			"Seats Left: " + seatsLeft +"\n"+
			"Slot Booking Cost: " + slotBookingCost +"\n"+
			"-----------------------------------";
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

	public int getSeatsLeft() {
		return seatsLeft;
	}

	public void setSeatsLeft(int seatsLeft) {
		this.seatsLeft = seatsLeft;
	}

	public int getSlotBookingCost() {
		return slotBookingCost;
	}

	public void setSlotBookingCost(int slotBookingCost) {
		this.slotBookingCost = slotBookingCost;
	}
}
