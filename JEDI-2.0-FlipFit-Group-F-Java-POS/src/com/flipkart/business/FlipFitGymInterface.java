package com.flipkart.business;

import com.flipkart.bean.Booking;

import java.util.List;

public interface FlipFitGymInterface {
    public void createBooking(int userId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount);

    public void bookSlots();

    public List<Booking> viewBookings(int userId);

    public void cancelBookings(int bookingId);

    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment) ;
}
