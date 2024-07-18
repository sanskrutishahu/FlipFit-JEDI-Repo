package com.flipkart.business;

import com.flipkart.bean.Booking;

import java.util.List;

public interface FlipFitGymBookingInterface {
    public void createBooking(int bookingId, int userId, int slotId, String bookingDate, String bookingTimeSlotStart, String bookingTimeSlotEnd, int bookingStatus, int transactionId, int bookingAmount);

    public void bookSlots(int bookingId, int userId, int slotId, String bookingDate, String bookingTimeSlotStart, String bookingTimeSlotEnd, int bookingStatus, int transactionId, int bookingAmount);

    public List<Booking> viewBookings(int userId);

    public void cancelBookings(int bookingId);

    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment) ;
}
