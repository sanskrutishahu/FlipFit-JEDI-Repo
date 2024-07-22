package com.flipkart.bean;
/**
 * The Booking class represents a booking made by a user for a specific time slot in a gym.
 * Contains details such as booking ID, user ID, slot ID, booking date and time, status, transaction ID, and amount.
 */
public class Booking {

    private int bookingId;
    private int userId;
    private int slotId;
    private String bookingDate;
    private String bookingTimeSlotStart;
    private String bookingTimeSlotEnd;
    private int bookingStatus;
    private int transactionId;
    private int bookingAmount;

    /**
     * Constructor to initialize a Booking object with all fields.
     *
     * @param bookingId          the unique identifier for the booking
     * @param userId             the ID of the user who made the booking
     * @param slotId             the ID of the slot that was booked
     * @param bookingDate        the date when the booking was made
     * @param bookingTimeSlotStart the start time of the booking
     * @param bookingTimeSlotEnd the end time of the booking
     * @param bookingStatus      the status of the booking
     * @param transactionId      the ID of the transaction associated with the booking
     * @param bookingAmount      the amount paid for the booking
     */
    public Booking(int bookingId, int userId, int slotId, String bookingDate, String bookingTimeSlotStart, String bookingTimeSlotEnd, int bookingStatus, int transactionId, int bookingAmount) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.slotId = slotId;
        this.bookingDate = bookingDate;
        this.bookingTimeSlotStart = bookingTimeSlotStart;
        this.bookingTimeSlotEnd = bookingTimeSlotEnd;
        this.bookingStatus = bookingStatus;
        this.transactionId = transactionId;
        this.bookingAmount = bookingAmount;
    }
    /**
     * Returns a string representation of the booking object.
     * The string includes all the details of the booking.
     *
     * @return a string representation of the booking
     */
    @Override
    public String toString() {
        return "---------------------------All Bookings-----------------------------\n" +
                "Booking ID: " + bookingId + "\n" +
                "User ID: " + userId + "\n" +
                "Slot ID: " + slotId + "\n" +
                "Date of Booking: '" + bookingDate + '\'' + "\n" +
                "Start time of booking: '" + bookingTimeSlotStart + '\'' + "\n" +
                "End time of booking: '" + bookingTimeSlotEnd + '\'' + "\n" +
                "Status of booking: " + bookingStatus + "\n" +
                "Transaction ID: " + transactionId + "\n" +
                "Amount of booking: " + bookingAmount + "\n" +
                "--------------------------------------------------------------------";
    }
    // Getter and setter methods for each field
    /**
     * Gets the booking ID.
     *
     * @return the booking ID
     */
    public int getBookingId() {
        return bookingId;
    }
    /**
     * Sets the booking ID.
     *
     * @param bookingId the booking ID to set
     */
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
    /**
     * Gets the user ID.
     *
     * @return the user ID
     */

    public int getUserId() {
        return userId;
    }
    /**
     * Sets the user ID.
     *
     * @param userId the user ID to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    /**
     * Gets the slot ID.
     *
     * @return the slot ID
     */
    public int getSlotId() {
        return slotId;
    }
    /**
     * Sets the slot ID.
     *
     * @param slotId the slot ID to set
     */
    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }
    /**
     * Gets the booking date.
     *
     * @return the booking date
     */
    public String getBookingDate() {
        return bookingDate;
    }
    /**
     * Sets the booking date.
     *
     * @param bookingDate the booking date to set
     */
    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }
    /**
     * Gets the start time of the booking.
     *
     * @return the start time of the booking
     */
    public String getBookingTimeSlotStart() {
        return bookingTimeSlotStart;
    }
    /**
     * Sets the start time of the booking.
     *
     * @param bookingTimeSlotStart the start time of the booking to set
     */
    public void setBookingTimeSlotStart(String bookingTimeSlotStart) {
        this.bookingTimeSlotStart = bookingTimeSlotStart;
    }
    /**
     * Gets the booking status.
     *
     * @return the booking status
     */
    public int getBookingStatus() {
        return bookingStatus;
    }
    /**
     * Sets the booking status.
     *
     * @param bookingStatus the booking status to set
     */
    public void setBookingStatus(int bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
    /**
     * Gets the end time of the booking.
     *
     * @return the end time of the booking
     */
    public String getBookingTimeSlotEnd() {
        return bookingTimeSlotEnd;
    }
    /**
     * Sets the end time of the booking.
     *
     * @param bookingTimeSlotEnd the end time of the booking to set
     */
    public void setBookingTimeSlotEnd(String bookingTimeSlotEnd) {
        this.bookingTimeSlotEnd = bookingTimeSlotEnd;
    }
    /**
     * Gets the transaction ID.
     *
     * @return the transaction ID
     */
    public int getTransactionId() {
        return transactionId;
    }
    /**
     * Sets the transaction ID.
     *
     * @param transactionId the transaction ID to set
     */
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
    /**
     * Gets the booking amount.
     *
     * @return the booking amount
     */
    public int getBookingAmount() {
        return bookingAmount;
    }
    /**
     * Sets the booking amount.
     *
     * @param bookingAmount the booking amount to set
     */
    public void setBookingAmount(int bookingAmount) {
        this.bookingAmount = bookingAmount;
    }
}
