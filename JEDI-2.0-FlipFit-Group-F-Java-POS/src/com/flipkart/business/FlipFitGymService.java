package com.flipkart.business;

import com.flipkart.bean.Booking;

import java.util.List;

public class FlipFitGymService implements FlipFitGymInterface {


    @Override
    public void createBooking(int userId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) {

    }

    @Override
    public void bookSlots() {

    }

    @Override
    public List<Booking> viewBookings(int userId) {
        return List.of();
    }

    @Override
    public void cancelBookings(int bookingId) {

    }

    @Override
    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment) {
        return 0;
    }
}
