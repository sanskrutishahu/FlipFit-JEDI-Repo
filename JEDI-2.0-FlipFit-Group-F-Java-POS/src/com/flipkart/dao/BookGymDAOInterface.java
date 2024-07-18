package com.flipkart.dao;

import com.flipkart.bean.Booking;

import java.util.List;

public interface BookGymDAOInterface {

    public void createBooking(int bookingId, int userId, int slotId, String bookingDate, String bookingTimeSlotStart, String bookingTimeSlotEnd, int bookingStatus, int transactionId, int bookingAmount);

    public void bookSlots(int bookingId, int userId, int slotId, String bookingDate, String bookingTimeSlotStart, String bookingTimeSlotEnd, int bookingStatus, int transactionId, int bookingAmount);

    public List<Booking> viewBookings(int userId);

    public void cancelBookings(int bookingId);

}
