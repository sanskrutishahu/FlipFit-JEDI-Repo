package com.flipkart.bean;

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

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTimeSlotStart() {
        return bookingTimeSlotStart;
    }

    public void setBookingTimeSlotStart(String bookingTimeSlotStart) {
        this.bookingTimeSlotStart = bookingTimeSlotStart;
    }

    public int getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(int bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getBookingTimeSlotEnd() {
        return bookingTimeSlotEnd;
    }

    public void setBookingTimeSlotEnd(String bookingTimeSlotEnd) {
        this.bookingTimeSlotEnd = bookingTimeSlotEnd;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(int bookingAmount) {
        this.bookingAmount = bookingAmount;
    }
}
