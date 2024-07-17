package com.flipkart.business;

import com.flipkart.bean.Booking;

import java.util.List;

public interface FlipFitGymBookingInterface {
    public void createBooking(Booking booking);

    public void bookSlots(Booking booking);

    public List<Booking> viewBookings(int userId);

    public void cancelBookings(int bookingId);

    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment) ;
}
