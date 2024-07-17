package com.flipkart.dao;

import com.flipkart.bean.Booking;

import java.util.List;

public interface BookGymDAOInterface {

    public void createBooking(Booking bookings);

    public void bookSlots(Booking booking);

    public List<Booking> viewBookings(int userId);

    public void cancelBookings(int bookingId);

}
