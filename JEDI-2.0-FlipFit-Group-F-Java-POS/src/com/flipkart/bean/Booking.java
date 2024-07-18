package com.flipkart.bean;

public class Booking {
    private int bookingId;
    private int userId;
    private int slotId;
    private int status;
    private int transactionId;
    private int bookingAmount;

    public Booking(int bookingId, int customerId, int slotId, int status, int transactionId, int bookingAmount) {
        this.bookingId = bookingId;
        this.userId = customerId;
        this.slotId = slotId;
        this.status = status;
        this.transactionId = transactionId;
        this.bookingAmount = bookingAmount;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
