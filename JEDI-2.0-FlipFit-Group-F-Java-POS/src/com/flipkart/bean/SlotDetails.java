package com.flipkart.bean;

/**
 * The SlotDetails class represents the details of a slot in a gym.
 * It includes information such as the slot ID, gym ID, date, start and end times, number of seats, and seats left.
 */
public class SlotDetails {

	private int slotID;
	private int gymId;
	private String date;
	private String startTime;
	private String endTime;
	private int noOfSeats;
	private int seatsLeft;

	/**
	 * Constructor to initialize a SlotDetails object with all fields.
	 *
	 * @param gymId       the unique identifier for the gym
	 * @param slotID      the unique identifier for the slot
	 * @param date        the date of the slot
	 * @param startTime   the start time of the slot
	 * @param endTime     the end time of the slot
	 * @param noOfSeats   the total number of seats available for the slot
	 */
	public SlotDetails(int gymId, int slotID, String date, String startTime, String endTime, int noOfSeats) {
		this.gymId = gymId;
		this.slotID = slotID;
		this.date = date;
		this.startTime = startTime;
		this.noOfSeats = noOfSeats;
		this.endTime = endTime;
		this.seatsLeft = noOfSeats;
	}

	/**
	 * Returns a string representation of the slot details.
	 *
	 * @return a string containing all the slot details
	 */
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
						"-----------------------------------";
	}

	/**
	 * Gets the unique identifier for the slot.
	 *
	 * @return the slot ID
	 */
	public int getSlotID() {
		return slotID;
	}

	/**
	 * Sets the unique identifier for the slot.
	 *
	 * @param slotID the slot ID to set
	 */
	public void setSlotID(int slotID) {
		this.slotID = slotID;
	}

	/**
	 * Gets the unique identifier for the gym.
	 *
	 * @return the gym ID
	 */
	public int getGymId() {
		return gymId;
	}
	/**
	 * Sets the unique identifier for the gym.
	 *
	 * @param gymId the gym ID to set
	 */
	public void setGymId(int gymId) {
		this.gymId = gymId;
	}

	/**
	 * Gets the date of the slot.
	 *
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the date of the slot.
	 *
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Gets the start time of the slot.
	 *
	 * @return the start time
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * Sets the start time of the slot.
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * Gets the end time of the slot.
	 *
	 * @return the end time
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * Sets the end time of the slot.
	 *
	 * @param endTime the end time to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * Gets the total number of seats available for the slot.
	 *
	 * @return the total number of seats
	 */
	public int getNoOfSeats() {
		return noOfSeats;
	}

	/**
	 * Sets the total number of seats available for the slot.
	 *
	 * @param noOfSeats the number of seats to set
	 */
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	/**
	 * Gets the number of seats left for the slot.
	 *
	 * @return the number of seats left
	 */
	public int getSeatsLeft() {
		return seatsLeft;
	}

	/**
	 * Sets the number of seats left for the slot.
	 *
	 * @param seatsLeft the number of seats left to set
	 */
	public void setSeatsLeft(int seatsLeft) {
		this.seatsLeft = seatsLeft;
	}
}