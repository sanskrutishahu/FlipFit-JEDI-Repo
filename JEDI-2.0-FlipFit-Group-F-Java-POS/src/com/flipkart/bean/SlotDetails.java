package com.flipkart.bean;

import java.sql.Time;

public class SlotDetails {

	private int slotID;
	private int centreID;
	private Time startTime;
	private Time endTime;
	private int noOfSeats;

	public SlotDetails(int slotID, int centreID, Time startTime, Time endTime, int noOfSeats) {
		this.slotID = slotID;
		this.centreID = centreID;
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

	public int getCentreID() {
		return centreID;
	}

	public void setCentreID(int centreID) {
		this.centreID = centreID;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

}
