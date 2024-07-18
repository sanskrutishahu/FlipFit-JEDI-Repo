package com.flipkart.dao;

import com.flipkart.bean.Booking;

import java.util.List;

public class BookGymDAOImpl implements BookGymDAOInterface{

    @Override
    public void createBooking(int bookingId, int userId, int slotId, String bookingDate, String bookingTimeSlotStart, String bookingTimeSlotEnd, int bookingStatus, int transactionId, int bookingAmount) {

    }

    @Override
    public void bookSlots(int bookingId, int userId, int slotId, String bookingDate, String bookingTimeSlotStart, String bookingTimeSlotEnd, int bookingStatus, int transactionId, int bookingAmount) {

    }

    @Override
    public List<Booking> viewBookings(int userId) {
        return List.of();
    }

    @Override
    public void cancelBookings(int bookingId) {

    }
}
